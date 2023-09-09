package _04_netflix;

public class NetflixRunner {

	public static void main(String[] args) {
		Movie harryPotter1 = new Movie("Harry Potter 1", 9);
		Movie harryPotter2 = new Movie("Harry Potter 2", 7);
		Movie harryPotter3 = new Movie("Harry Potter 3", 6);
		Movie harryPotter4 = new Movie("Harry Potter 4", 8);
		Movie harryPotter5 = new Movie("Harry Potter 5", 7);
		
		harryPotter1.getTicketPrice();
		
		NetflixQueue queue = new NetflixQueue();
		
		queue.addMovie(harryPotter1);
		queue.addMovie(harryPotter2);
		queue.addMovie(harryPotter3);
		queue.addMovie(harryPotter4);
		queue.addMovie(harryPotter5);
		
		queue.printMovies();
		
		queue.sortMoviesByRating();
		
		System.out.println("The best movie is: " + queue.getBestMovie());
		System.out.println("The second best movie is: " + queue.getMovie(1));
	}

}


//1. Instantiate some Movie objects (at least 5).
//2. Use the Movie class to get the ticket price of one of your movies.
//3. Instantiate a NetflixQueue.
//4. Add your movies to the Netflix queue.
//5. Print all the movies in your queue.
//6. Use your NetflixQueue object to finish the sentence "the best movie is...."
//7. Use your NetflixQueue to finish the sentence "the second best movie is...."
