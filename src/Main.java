import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.*;
import java.io.File;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream output = new PrintStream("Playlist.txt");     //Creates  a text file  for the outputs
//        TopSongs playList = new TopSongs();
        Tree Binarytree = new Tree();
        String line = "";
        String[] title = new String[200];
        String[] artist = new String[200];
        String[] myFiles = new String[]{"regional-global-weekly-2020-09-18--2020-09-25.csv", "regional-global-weekly-2020-09-11--2020-09-18.csv", "regional-global-weekly-2020-09-04--2020-09-11.csv",
                "regional-global-weekly-2020-08-28--2020-09-04.csv", "regional-global-weekly-2020-08-21--2020-08-28.csv", "regional-global-weekly-2020-08-14--2020-08-21.csv",
                "regional-global-weekly-2020-08-07--2020-08-14.csv", "regional-global-weekly-2020-07-31--2020-08-07.csv", "regional-global-weekly-2020-07-24--2020-07-31.csv",
                "regional-global-weekly-2020-07-17--2020-07-24.csv", "regional-global-weekly-2020-07-10--2020-07-17.csv", "regional-global-weekly-2020-07-03--2020-07-10.csv",
                "regional-global-weekly-2020-06-26--2020-07-03.csv"};
        try {
            for (int i = 0; i < myFiles.length - 1; i++) {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\somet\\IdeaProjects\\PlayListBST\\src\\" + myFiles[i]));        //Reads in each csv file
                while ((line = br.readLine()) != null) {

                    String[] values = line.split(",");
                    if (Character.isWhitespace(values[2].charAt(0))) {                    //removes the extra spacing
                        values[2] = values[2].substring(1);
                    }
                    Song song = new Song(values[1].replaceAll("\"", ""), values[2].replaceAll("\"", ""), values[3]);       //removes all instances of a " in the file
//                    playList.insert(song);                                              //adds songs to Linked List
                    Binarytree.insert(song);
                    Binarytree.display(song);
                }
            }

        } catch (FileNotFoundException e) {                        //exception handling
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Song implements Comparable<Song>{     //created song object class
    private String title, artist,streams;
    public Song left, right;
    public Song next;

    Song(String title, String artist, String streams){
        this.title = title;
        this.streams = streams;
        this.artist = artist;
    }

    public Song getNext() {
        return next;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getStreams() {
        return streams;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStreams(String streams) {
        this.streams = streams;
    }

    public void setNext(Song next) {
        this.next = next;
    }
    @Override
    public int compareTo(Song songtwo){                                                                     //sorting algorithm to alphabetically sort by song titles
        if(this.title.toLowerCase().compareTo(songtwo.getTitle().toLowerCase())> 0){
            return 1;
        }
        if (this.title.toLowerCase().compareTo(songtwo.getTitle().toLowerCase()) < 0) {
            return -1;
        }
        return 0;
    }
    @Override
    public String toString(){
        return this.title;
    }
}