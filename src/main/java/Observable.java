public interface Observable {
    public final String FBIEvent = "FBI_EVENT";
    public final String OwnerEvent = "OWNER_EVENT";
    public void registerObserver(Object personToNotify);
    public void notifyObservers(String eventType,Object result);
}