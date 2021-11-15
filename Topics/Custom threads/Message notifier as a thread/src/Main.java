class MessageNotifier extends Thread {

    private String msg;
    private int repeats;

    public MessageNotifier(String msg, int repeats) {
        for (int i = 0; i < repeats; i++) {
            System.out.println(msg);
        }
    }

    @Override
    public void run() {
        MessageNotifier messageNotifier = new MessageNotifier(msg, repeats);
    }
}