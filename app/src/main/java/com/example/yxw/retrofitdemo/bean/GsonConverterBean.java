package com.example.yxw.retrofitdemo.bean;

import java.util.List;

/**
 * 测试GsonConverter,直接解析成JavaBean
 * Created by yxw on 2016/12/23.
 */

public class GsonConverterBean {

    private int count;
    private int err;
    private int total;
    private int page;
    private int refresh;
    private List<ItemsBean> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * format : word
         * image : null
         * published_at : 1482447302
         * tag :
         * user : {"avatar_updated_at":1463865729,"medium":"//pic.qiushibaike.com/system/avtnew/3118/31187946/medium/20160522052159.jpg","thumb":"//pic.qiushibaike.com/system/avtnew/3118/31187946/thumb/20160522052159.jpg","last_visited_at":1455254163,"created_at":1455254163,"updated_at":1477438012,"state":"bonded","role":"","login":"依然范特西:","last_device":"android_9.1.0","id":31187946,"icon":"20160522052159.jpg"}
         * image_size : null
         * id : 118242193
         * votes : {"down":-9,"up":333}
         * created_at : 1482445738
         * content : 我有个朋友排行老三，平常都叫他小三儿。
         这天一起去逛街，我系鞋带的功夫小三儿走那么远，我就在后面喊他:小三儿你别走，给劳资站住。
         前面几个好心的大姐听见我喊，把小三儿截住合伙揍了一顿。
         * state : publish
         * comments_count : 13
         * allow_comment : true
         * share_count : 5
         * type : fresh
         */

        private String format;
        private Object image;
        private int published_at;
        private String tag;
        private UserBean user;
        private Object image_size;
        private int id;
        private VotesBean votes;
        private int created_at;
        private String content;
        private String state;
        private int comments_count;
        private boolean allow_comment;
        private int share_count;
        private String type;

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public int getPublished_at() {
            return published_at;
        }

        public void setPublished_at(int published_at) {
            this.published_at = published_at;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public Object getImage_size() {
            return image_size;
        }

        public void setImage_size(Object image_size) {
            this.image_size = image_size;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public VotesBean getVotes() {
            return votes;
        }

        public void setVotes(VotesBean votes) {
            this.votes = votes;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public boolean isAllow_comment() {
            return allow_comment;
        }

        public void setAllow_comment(boolean allow_comment) {
            this.allow_comment = allow_comment;
        }

        public int getShare_count() {
            return share_count;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static class UserBean {
            /**
             * avatar_updated_at : 1463865729
             * medium : //pic.qiushibaike.com/system/avtnew/3118/31187946/medium/20160522052159.jpg
             * thumb : //pic.qiushibaike.com/system/avtnew/3118/31187946/thumb/20160522052159.jpg
             * last_visited_at : 1455254163
             * created_at : 1455254163
             * updated_at : 1477438012
             * state : bonded
             * role :
             * login : 依然范特西:
             * last_device : android_9.1.0
             * id : 31187946
             * icon : 20160522052159.jpg
             */

            private int avatar_updated_at;
            private String medium;
            private String thumb;
            private int last_visited_at;
            private int created_at;
            private int updated_at;
            private String state;
            private String role;
            private String login;
            private String last_device;
            private int id;
            private String icon;

            public int getAvatar_updated_at() {
                return avatar_updated_at;
            }

            public void setAvatar_updated_at(int avatar_updated_at) {
                this.avatar_updated_at = avatar_updated_at;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getLogin() {
                return login;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public String getLast_device() {
                return last_device;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class VotesBean {
            /**
             * down : -9
             * up : 333
             */

            private int down;
            private int up;

            public int getDown() {
                return down;
            }

            public void setDown(int down) {
                this.down = down;
            }

            public int getUp() {
                return up;
            }

            public void setUp(int up) {
                this.up = up;
            }
        }
    }
}
