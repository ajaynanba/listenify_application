package listenify;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album = new Album("love songs", "Harris Jayaraj");
        album.addSongInAlbum("vizhi mudi", 4.5);
        album.addSongInAlbum("suttum vizhi", 5.5);
        album.addSongInAlbum("poopol", 4.6);

        albums.add((album));

        album = new Album("drugs", "Yuvan");
        album.addSongInAlbum("oru Naalil", 5.5);
        album.addSongInAlbum("kan Pesum", 6.5);
        album.addSongInAlbum("pogathe", 5.8);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addSongToPlayList("Thenmozhi", playList_1);
        albums.get(0).addSongToPlayList("Mudhar Kanave", playList_1);
        albums.get(1).addSongToPlayList("enna vilai", playList_1);
        albums.get(1).addSongToPlayList("Idhazhin Oram", playList_1);

        play(playList_1);



    }


    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }

    public static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size()==0) return;
        Scanner sc = new Scanner(System.in);

        boolean forward = true;
        boolean quit = false;
        System.out.println("Now Playing" + listIterator.next());
        while(quit==false) {
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (forward == false) {
                        listIterator.hasNext();
                        forward = true;
                    }
                    if (listIterator.hasNext()) {

                        System.out.println(listIterator.next().toString());
                    } else {
                        System.out.println("you are at the last song");

                    }
                    break;
                case 2:
                    if (forward == true) {
                        listIterator.hasPrevious();
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println(listIterator.previous().toString());
                    } else System.out.println("you are at the first song");
                    break;
                case 3:
                    if (forward == true) {
                        System.out.println(listIterator.previous().toString());
                        forward = false;
                    } else {
                        System.out.println(listIterator.next().toString());
                        forward = true;
                    }
                    break;
                case 4:
                    printAllSongs(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        System.out.println("Song has been removed from the playList");

                    }
                    if (playList.size() > 0 && listIterator.hasPrevious()) {
                        System.out.println("now playing" + listIterator.previous().toString());
                    }
                    else if (playList.size() > 0 && listIterator.hasNext()) {
                        System.out.println("now playing" + listIterator.next().toString());
                    }
                    break;
            }
        }
    }
    private static void printAllSongs(LinkedList<Song> songs){

        //Try for each loop
        ListIterator<Song> listIterator = songs.listIterator();

        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }
}