

public class GuessingGame {
	
	private int range;
	
	private int randomNumber;
	private int numberOfGuesses;
	
	public GuessingGame(int range){
		this.range = range;
		newGame();
	}
	
    public void newGame() {
    	randomNumber = (int) (Math.random() * range + 1);
		numberOfGuesses = 0;
    }
	
	public GuessResult makeGuess(int guess) {
		numberOfGuesses++;
		boolean isClose = Math.abs(guess-randomNumber) < Config.CLOSE_LIMIT;
		if (guess < randomNumber) {
			return isClose ? GuessResult.tooSmallButClose : GuessResult.tooSmall;
		} else if (guess > randomNumber) {
			return isClose ? GuessResult.tooLargeButClose : GuessResult.tooLarge;
		} else {
			return GuessResult.correct;
		}			
	}

	public int getNumberOfGuesses() {
		return numberOfGuesses;
	}

	public int getRange() {
		return range;
	}
	

}


