public class Board
{
        private int x = 100;
        private int y = 100;
        private int player1x = 150;
        private int player1y = 270;
        private int player2x = 850;
        private int player2y = 270;
        private int topMagnetx = 500;
        private int topMagnety = 150;
        private int middleMagnetx = 500;
        private int middleMagnety = 300;
        private int bottomMangetx = 500;
        private int bottomMagnety = 450;
        private GameArena gameBoard;
        private Ball player1;
        private Ball player2;
        private Ball mainBall;
        private Ball middleMagnet;
        private Ball topMagnet;
        private Ball bottomMagnet;



        public Board(){
        
        
        this.gameBoard = new GameArena(1000,600);
        Rectangle background = new Rectangle(50,50,900,500,"BLUE");
        this.mainBall = new Ball(x,y,30,"yellow");
        Ball leftTop = new Ball(60,60,80,"WHITE");
        Ball leftBottom = new Ball(60,540,80,"WHITE");
        Ball rightTop = new Ball(940,60,80,"WHITE");
        Ball rightBottom = new Ball(940,540,80,"WHITE");
        Ball leftTopCenter = new Ball(60,60,70,"blue");
        Ball leftBottomCenter = new Ball(60,540,70,"blue");
        Ball rightTopCenter = new Ball(940,60,70,"blue");
        Ball rightBottomCenter = new Ball(940,540,70,"blue");
        Line middleLine = new Line(500,50,500,550,2,"WHITE",2);
        this.topMagnet = new Ball(topMagnetx,topMagnety,25,"white");
        this.middleMagnet = new Ball(middleMagnetx,middleMagnety,25,"white");
        this.bottomMagnet = new Ball(bottomMangetx,bottomMagnety,25,"white");
        Ball leftGoal = new Ball(100,300,40,"WHITE");
        Ball rightGoal = new Ball(900,300,40,"WHITE");
        this.player1 = new Ball(player1x, player1y,35,"black",3);
        this.player2 = new Ball(player2x,player2y, 35,"black", 3);
        //add boarder so it looks better

        gameBoard.addBall(mainBall);
        gameBoard.addRectangle(background);
        gameBoard.addBall(leftTop);
        gameBoard.addBall(leftBottom);
        gameBoard.addBall(rightTop);
        gameBoard.addBall(rightBottom);
        gameBoard.addBall(leftTopCenter);
        gameBoard.addBall(leftBottomCenter);
        gameBoard.addBall(rightTopCenter);
        gameBoard.addBall(rightBottomCenter);
        gameBoard.addLine(middleLine);
        gameBoard.addBall(topMagnet);
        gameBoard.addBall(middleMagnet);
        gameBoard.addBall(bottomMagnet);
        gameBoard.addBall(leftGoal);
        gameBoard.addBall(rightGoal);
        gameBoard.addBall(player1);
        gameBoard.addBall(player2);
           
}
            
        
        public GameArena getArena()
        {
            return gameBoard;
        }

        public double getPlayer1y(){
            return player1.getYPosition();
        }
        
        public double getPlayer1x(){
            return player1.getXPosition();
 
       }    
       public Ball getPlayer1()
       {
            return player1;
       }
       public Ball getPlayer2()
        {
            return player2;
        }
       
       public Ball getBall()
        {
            return mainBall;
        }
       public Ball getmidMagnet()
       {
           return middleMagnet;
       }
       public Ball gettopMagnet()
       {
           return topMagnet;
       }
       public Ball getbotMagnet()
       {
           return bottomMagnet;
       }

}