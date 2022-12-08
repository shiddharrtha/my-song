public class MyMix {
    public static void main(String[] args) {

        //Make a Song array of size 5
        Song[] songs = new Song[5];

        //fill the Song array with some objects
        //make 4 Song objects (one of them will be used to pass to a method, only 3 will go in initial array)
        //the other two make on the same line as storing
        Song superman = new Song("goldfinger", "superman", 3.05);
        Song almost = new Song("bowling for soup", "almost", 4.26);
        Song paradise = new Song("george ezra", "paradise", 2.42);
        Song go = new Song("elsa", "let it go", 3.30);

        songs[0] = go;
        songs[1] = superman;
        songs[2] = paradise;
        songs[3] = new Song("owl city", "fireflies", 2.50);
        songs[4] = new Song("alien ant farm", "movies", 5.04);


        //call method to print out array
        printArr(songs);

        //call method that updates a Song at a passed index number
        //use the 4 Song object created above to replace another song
        updateSong(songs, 3, almost);

        //call method to print out array
        System.out.println("Back in main");
        printArr(songs);

        songs[0].createLyrics("usbhiwbiuhwebhf");
        songs[1].createLyrics("usbhiwbiuhwebhf");
        songs[2].createLyrics("usbhiwbiuhwebhf");
        songs[3].createLyrics("usbhiwbiuhwebhf");
        songs[4].createLyrics("usbhiwbiuhwebhf");

        //call method to find out how many songs can win awards
        //store this return into a new Song[]
        //we don't need to set the size here because our size will be whatever the size of the return is
        Song[] winners = awardSongs(songs);


        //call method to give speech for award song
        //use the award Song[] as an argument
        //store this return in a String
        String sp = speech(winners);

        //print out the speech given
        System.out.println(sp);


    }//end of main


    //create method to print out array (printArr)
    //return void
    //take a Song[] as a parameter
    //use enhanced for loop
    //print out each Song object (overrode toString so just need the object)
    public static void printArr(Song[] s){
        for(Song song : s){
            System.out.println(song);
        }
        System.out.println();
    } // end of printArr method


    //create method to update a Song in the [] (updateSong)
    //return void
    //take a Song[] as a parameter
    //take an index as a parameter
    //test to make sure index is within the array
    //if not tell the user and do nothing
    //if index is valid update index with new Song object
    //call method to print out array
    //(this will show that changing an array in a method affects arrays outside the method,
    //true for any reference type value)
    public static void updateSong(Song[] s, int index, Song replacement){
        if(index < s.length){
            s[index] = replacement;
            System.out.println("In update");
            printArr(s);
        } else {
            System.out.println("Bad index number, try again.");
        }
    }// end of updateSong method

    //create a method to return the Songs that can win awards (awardSongs)
    //return a Song[]
    //take a Song[] as a parameter
    //create awardSong[] (make same length as parameter array because every Song could win)
    //use normal for loop to go over the array
    //each Song element call canWinAward
    //if true add it to the awardSong[] (will need a second index counter for this array)
    public static Song[] awardSongs(Song[] s){
        Song[] awardSong = new Song[s.length];
        int index = 0;
        for(int i = 0; i < s.length; i++){
            boolean winner = s[i].canWinAward();
            if(winner){
                awardSong[index] = s[i];
                index++;
            }
        }
        return awardSong;
    }


    //create a method that will give a speech for a Song that has won an award
    //return a String (this will be the speech given)
    //take a Song[] as a parameter
    //use a normal for loop to go over the array
    //each Song element get the artist
    //test the artist name for that Song
    //check to see if the artist is Kanye
    //if it is not lunatic have lunatic interrupt the speech with his own ramblings
    public static String speech(Song[] s){
        for( int i = 0; i < s.length; i++){
            String artist = s[i].getArtist();
            if(!"lunatic".equals(artist)){
                return "i should be giving this speech";
            }
        }
        return "look we made it here";
    }

}//end of class
