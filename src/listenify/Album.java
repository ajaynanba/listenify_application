package listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    public String albumName;
    public String artistName;

    public List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSongInAlbum(String songName) {
        for (Song song : songList) {
            if (song.songName == songName) return true;

        }
        return false;
    }
    public String addSongInAlbum(String songName,double duration){
        if(findSongInAlbum(songName) == true) return "the Song is already present in the album";
        else{
            Song newSong = new Song(songName,duration);
            songList.add(newSong);
            return "Successfully the song is added";
        }
    }
    public String addSongToPlayList(String songName, LinkedList<Song> playList){
        for(Song song : songList){
            if(songName == song.songName) return "Song is already in the playlist";
            else playList.add(song);
        }
        return "Song has been added succesfully";
    }
}
