package observer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Getter @Setter
public class SMSUsers implements Observer {
    private Subject s;
    private String msg;
    private String name;

    public SMSUsers(Subject s, String msg) {
        this.s = s;
        this.msg = msg;
    }

    @Override
    public void update(String desc) {
        System.out.println(getName() + " received: " + desc);
    }

    @Override
    public void subscribe() {
        s.subscribeObserver(this);
    }

    @Override
    public void unSubscribe() {
        s.unSubscribeObserver(this);
    }
}
