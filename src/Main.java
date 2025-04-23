public class Main { 
    
    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        Gui frame = new Gui();
        Thread thread = new Thread(frame.getView()); 
        thread.start();
    }
}
