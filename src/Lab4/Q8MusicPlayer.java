package Lab4;

import java.util.Scanner;

public class Q8MusicPlayer {

    Q7CircularLinkedList<Q8Music> list;
    int currentSongIndex = -1;

    public Q8MusicPlayer() {
        list = new Q7CircularLinkedList<>();
    }

    public void addSong(String name, String fileName) {
        //assume current song is the latest song
        currentSongIndex++;
        list.addCircularNode(new Q8Music(name, fileName));
    }

    public void showMyList() {
        list.showCircularList();
        System.out.println("1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit");
        System.out.print("Your option : ");
    }

    public void performOption(int option) {
        boolean exit = false;
        switch (option) {
            case 1:
                break;
            case 2:
                System.out.print("Forward One Position - ");
                currentSongIndex = (currentSongIndex + 1) % list.length();
                break;
            case 3:
                System.out.print("Backward One Position - ");
                if ((currentSongIndex - 1) < 0) {
                    currentSongIndex = list.length() - 1;
                } else {
                    currentSongIndex--;
                }
                break;
            case 4:
                System.out.println("Stop Playing");
                showMyList();
                return;
            case -1:
                System.out.println("Exit Music Player");
                exit = true;
                break;
            default:
                System.out.println("Not a valid option");
        }
        if (!exit) {
            System.out.println("Play Music " + list.getCircularItem(currentSongIndex).getTitle());
            showMyList();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Q8MusicPlayer myPlayer = new Q8MusicPlayer();
        myPlayer.addSong("Best Song Ever", "C://1Direction");
        myPlayer.addSong("Kiss You", "C://1Direction");
        myPlayer.addSong("Night Changes", "C://1Direction");
        myPlayer.addSong("Lucky Strike", "C://Maroon5");
        System.out.println("My Music Play List");
        int option = -2;
        myPlayer.showMyList();
        do {
            option = s.nextInt();
            myPlayer.performOption(option);
        } while (option != -1);
    }
}
