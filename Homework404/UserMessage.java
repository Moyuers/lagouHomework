package Homework404;

import java.io.Serializable;

public class UserMessage implements Serializable {
    private static final long serialVersionUID = 5945463602319365594L;
    private String type;//类型
    private User userObj;//用户对象

    public UserMessage() {
    }

    public UserMessage(String type, User userObj) {
        setType(type);
        setUserObj(userObj);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUserObj() {
        return userObj;
    }

    public void setUserObj(User userObj) {
        this.userObj = userObj;
    }
}
