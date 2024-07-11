public class Game
{
    public static void main(String[] args){
        Board gameBoard = new Board();
        GameArena gameArena = gameBoard.getArena();
        PlayerMovement movement = new PlayerMovement(gameBoard);
        BallMove ballMovement = new BallMove(gameBoard);


        while(true)
        {
            movement.movement();
            ballMovement.collision();
            ballMovement.addxvelostiy();
            ballMovement.addyvelocity();
            gameArena.pause();
            
        }
    }
}