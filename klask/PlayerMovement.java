public class PlayerMovement
{
    private Board board;
    private GameArena game;
    private Ball player1;
    private Ball player2;
    private double xVelosity;
    private double yVelosity;
    private double xVelosityp1;
    private double yVelosityp1;
    private double xVelosityp2;
    private double yVelosityp2;

    public PlayerMovement(Board board)
    {
        this.board = board;
        this.game = board.getArena();
        this.player1 = board.getPlayer1();
        this.player2 = board.getPlayer2();
        }

    public void movement()
    {
        if (game.letterPressed('w')){
            if (player1.getYPosition() != 70)
            player1.move(0, -5);
            yVelosityp1 = -5;

        }
        if (game.letterPressed('s')){
            if (player1.getYPosition() != 530)
            player1.move(0 , 5);
            yVelosityp1 = 5;
        }

        if (game.letterPressed('a')){
            if (player1.getXPosition() != 75)
            player1.move(-5, 0);
            xVelosityp1 = -5;
        }

        if (game.letterPressed('d')){
            if (player1.getXPosition() != 450)
            player1.move(5, 0);
            xVelosityp1 = 5;
        }
        if (game.upPressed()){
            if (player2.getYPosition() != 70)
            player2.move(0, -5);
            yVelosityp2 = -5;
        }

        if (game.downPressed()){
            if (player2.getYPosition() != 530)
            player2.move(0, 5);
            yVelosityp2 = 5;
        }

        if (game.leftPressed()){
            if (player2.getXPosition() != 550)
            player2.move(-5, 0);
            xVelosityp2 = -5;
        }

        if (game.rightPressed()){
            if (player2.getXPosition() != 925)
            player2.move(5,0);
            xVelosityp2 = 5;
        }
    }
    public double getxVelosityp1()
        {
            return xVelosityp1;
        }
    public double getyVelosityp1()
        {
            return yVelosityp1; 
        }
    public double getxVelosityp2()
        {
            return xVelosityp2;
        }
    public double getyVelosityp2()
        {
            return yVelosityp2;
        }


}