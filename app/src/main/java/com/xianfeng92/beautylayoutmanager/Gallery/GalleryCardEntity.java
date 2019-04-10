package com.xianfeng92.beautylayoutmanager.Gallery;

/**
 * Created By zhongxianfeng on 19-4-10
 * github: https://github.com/xianfeng92
 */
public class GalleryCardEntity {

        private int postition;
        private String url;
        private String name;
        private String content;

        public GalleryCardEntity(int postition, String url, String name, String content) {
            this.postition = postition;
            this.url = url;
            this.name = name;
            this.content = content;
        }

        public int getPostition() {
            return postition;
        }

        public GalleryCardEntity setPostition(int postition) {
            this.postition = postition;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public GalleryCardEntity setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getName() {
            return name;
        }

        public GalleryCardEntity setName(String name) {
            this.name = name;
            return this;
        }


        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

}
