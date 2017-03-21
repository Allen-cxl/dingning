package com.dingning.card;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dingning.card.Callback.DialogCallback;
import com.dingning.card.adapter.MessageAdapter;
import com.dingning.card.api.AppConstants;
import com.dingning.card.api.Parameter;
import com.dingning.card.listener.OnItemClickListener;
import com.dingning.card.model.BaseResponse;
import com.dingning.card.model.Message;
import com.dingning.card.model.MessageList;
import com.dingning.card.model.NoticeEvent;
import com.dingning.card.model.ReadEvent;
import com.dingning.card.model.Student;
import com.dingning.card.utils.GlideRoundTransform;
import com.dingning.card.utils.StringUtils;
import com.dingning.card.weight.SpacesItemDecoration;
import com.lzy.okgo.OkGo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;


public class MessageListFragment extends BaseFragment implements OnItemClickListener {
    private static final String STUDENT = "student";
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rv_message)
    RecyclerView rvMessage;
    @BindView(R.id.tv_page)
    TextView tvPage;
    @BindView(R.id.bt_send_video)
    Button btSendVideo;
    @BindView(R.id.bt_send_voice)
    Button btSendVoice;
    @BindView(R.id.bt_next_page)
    Button btNextPage;
    MessageAdapter adapter;
    List<Message> lists;
    MessageList messageList;

    // TODO: Rename and change types of parameters
    private Student student;
    private String  carId;
    private int spacingInPixels = 20;
    private int p = 1;
    private int num = 6;
    private int total;
    private boolean isloading;
    private View mViewContent;
    private Message message ;

    public MessageListFragment() {
        // Required empty public constructor
    }

    public static MessageListFragment newInstance() {
        MessageListFragment fragment = new MessageListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        student = application.getStudent();
        carId = application.getCarId();
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(mViewContent == null){
            mViewContent = inflater.inflate(R.layout.fragment_message_list, container, false);
            ButterKnife.bind(this, mViewContent);
            initValue();
        }

        ViewGroup parent = (ViewGroup) mViewContent.getParent();
        if (parent != null) {
            parent.removeView(mViewContent);
        }
        return mViewContent;
    }


    private void initValue() {

        Glide.with(getActivity().getApplicationContext())
                .load(student.getStudent_pic())
                .crossFade()
                .transform(new GlideRoundTransform(getActivity(),15))
                .error(R.drawable.student)
                .into(ivAvatar);

        tvName.setText(student.getStudent_name());

        adapter = new MessageAdapter(getActivity());

        adapter.setOnItemClickListener(this);
        LinearLayoutManager li = new LinearLayoutManager(getActivity());
        li.setOrientation(LinearLayoutManager.VERTICAL);
        rvMessage.addItemDecoration(new SpacesItemDecoration(spacingInPixels, SpacesItemDecoration.LinearLayout));
        rvMessage.setLayoutManager(li);
        rvMessage.setAdapter(adapter);

        getMessage(p, num);
    }

    void getMessage(final int p, final int num){
        isloading = true;
        OkGo.post(AppConstants.GET_EXHORTLISTBYCARD_BY)
                .tag(this)
                .params(Parameter.CARD_ID, carId)
                .params(Parameter.P, p)
                .params(Parameter.NUM, num)
                .execute(new DialogCallback<BaseResponse<MessageList>>(getActivity()) {

                    @Override
                    public void onSuccess(BaseResponse<MessageList> baseResponse, Call call, Response response) {
                        isloading = false;
                        messageList = baseResponse.data;
                        total = Integer.valueOf(messageList.getTotal());
                        lists = messageList.getMessages();
                        adapter.addMoreDatas(lists);
                        int totalPage = StringUtils.getTotalPage(total, num);

                        if(lists != null && lists.size() > 0 ){
                            tvPage.setText("已加载"+ p+"页   "+"总共" + totalPage + "页");
                        }

                    }


                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);

                        isloading = false;
                    }
                });
    }

    @Subscribe
    public void onNoticeEvent(NoticeEvent event) {

        if(isAdded()){
            if(adapter != null){
                adapter.clear();
                p = 1;
                num = 10;
                getMessage(p, num);
            }
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        application.setCarId(null);
        application.setStudent(null);
        adapter.clear();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.bt_send_video, R.id.bt_send_voice, R.id.bt_next_page, R.id.bt_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_send_video:
                enterFragment(SelectObjectFragment.newInstance(Parameter.VIDEO));
                break;
            case R.id.bt_send_voice:
                enterFragment(SelectObjectFragment.newInstance(Parameter.VOICE));
                break;
            case R.id.bt_next_page:
                if(isloading){return;}
                p++ ;
                getMessage(p, num);
                break;
            case R.id.bt_back:

                onBack();
                break;
        }
    }

    @Subscribe
    public void onBuyEvent(ReadEvent event) {

        message.setState(Message.read+"");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, int position) {

        message =  adapter.getItem(position);
        enterFragment(MessageDetailFragment.newInstance(message));
    }
}
