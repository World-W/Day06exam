package com.example.wangshije20200224.base;

import java.util.List;
/*
 * 王世杰
 * 20200227
 * */

public class Bean {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private List<BannerBean> banner;
        private List<NewsistBean> newsist;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<NewsistBean> getNewsist() {
            return newsist;
        }

        public void setNewsist(List<NewsistBean> newsist) {
            this.newsist = newsist;
        }

        public static class BannerBean {
            /**
             * imageurl : http://blog.zhaoliang5156.cn/api/images/banner_01.jpg
             */

            private String imageurl;

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }
        }

        public static class NewsistBean {
            /**
             * title : 如何辨别儿童是否感染新型冠状病毒
             * content : 如何辨别儿童出现的发热症状是普通感冒、还是流感或新型冠状病毒？北京儿童医院急诊科主任王荃说，普通感冒、流感、新型冠状病毒三者的致病源、发病时间、症状和严重程度都不一样。新型冠状病毒感染是人群普遍易感，尤其是老…
             * author : LIFECARE心健康平台
             * time : 3小时前
             * image : http://5b0988e595225.cdn.sohucs.com/q_70,c_lfill,w_180,h_120,g_faces/images/20200219/a53e7a852c02439b83aa8a2e270632c8.jpeg
             */

            private String title;
            private String content;
            private String author;
            private String time;
            private String image;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}
