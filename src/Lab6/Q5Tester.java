package Lab6;
//He Lin's code
public class Q5Tester {
    public static void main(String[] args) {
        Q5PriorityQueue<Q5Packet> alex = new Q5PriorityQueue<>();
        Q5Packet a = new Q5Packet("Video 1");
        Q5Packet b = new Q5Packet("Voice 2");
        Q5Packet c = new Q5Packet("Data 3");
        Q5Packet d = new Q5Packet("Data 4");
        Q5Packet e = new Q5Packet("Voice 5");
        Q5Packet f = new Q5Packet("Video 6");
        Q5Packet g = new Q5Packet("Voice 7");
        Q5Packet h = new Q5Packet("Voice 8");
        Q5Packet i = new Q5Packet("Data 9");
        Q5Packet j = new Q5Packet("Video 10");
        alex.enqueue(a);
        alex.enqueue(b);
        alex.enqueue(c);
        alex.enqueue(d);
        alex.enqueue(e);
        alex.enqueue(f);
        alex.enqueue(g);
        alex.enqueue(h);
        alex.enqueue(i);
        alex.enqueue(j);
        alex.showQueue();
    }
}
