public interface Score {
    public void registerObserver(Observer aObserver);
    public void removeObserver(Observer bObserver);
    public void notifyObservers(int white_score, int black_score);
}
