package y2020.m01.d23.publishSubscribe.v2;

public class ConcreteSubject extends Subject {

  private String state;

  public void changeState( String newState){
    state = newState;
    notifyObservers();
  }

}