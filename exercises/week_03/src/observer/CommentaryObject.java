package observer;

import java.util.List;

/**
 *
 */
public class CommentaryObject implements Subject, Commentary {
    private List<Observer> subscribers;
    private String title;
    private String desc;

    public CommentaryObject(List<Observer> subscribers, String title) {
        this.subscribers = subscribers;
        this.title = title;
    }

    @Override
    public void subscribeObserver(Observer observer) {
        subscribers.add(observer);
        System.out.println(observer.hashCode() + " subscribed to " + subjectDetails());
    }

    @Override
    public void unSubscribeObserver(Observer observer) {
        subscribers.remove(observer);
        System.out.println(observer.hashCode() + " unsubscribed from " + title);
    }

    @Override
    public void notifyObservers() {
        subscribers.stream().forEach(observer -> {
            observer.update(desc);
        });
    }

    @Override
    public String subjectDetails() {
        return title;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
        notifyObservers();
    }

}
