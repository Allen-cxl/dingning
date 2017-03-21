package com.dingning.card.api;


public class AppConstants {

        public static final String HOST = "http://api.yudianedu.cn/v3/web/Rest";

        public final static String GET_SCHOOL_INFO = HOST + "/elecclasscard/getschoolinfo";          //获取学校信息

        public final static String GET_STUDENTINFO_BY = HOST + "/classcard/getstudentinfo_hy";          //获取学生信息

        public final static String GET_EXHORTLISTBYCARD_BY = HOST + "/classcard/getexhortlistbycard_hy";          //获取学生信息列表

        public final static String GET_EXHORTBYID_BY = HOST + "/classcard/getexhortbyid_hy";          //获取信息详情

        public final static String ADD_EXHORTREPLY_BY = HOST + "/classcard/addexhortreply_hy";          //上传视频，语音

        public final static String GET_CARDVERSION_BY = HOST + "/classcard/getcardversion_hy";          //版本更新

}
