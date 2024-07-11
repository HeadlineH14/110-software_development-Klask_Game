public class BallMove{

    private Board board;
    private GameArena game;
    private Ball player1;
    private Ball player2;
    private Ball ball;
    private Ball middleMagnet;
    private Ball topManget;
    private Ball bottmMagnet;
    private PlayerMovement velocityMovement;
    private double xVelosity;
    private double yVelosity;
    private double xVelosityp1;
    private double yVelosityp1;
    private double xVelosityp2;
    private double yVelosityp2;

    public BallMove(Board board)
    {
        this.board = board;
        this.game = board.getArena();
        this.player1 = board.getPlayer1();
        this.player2 = board.getPlayer2();
        this.ball = board.getBall();   
        this.middleMagnet = board.getmidMagnet();
        this.topManget = board.gettopMagnet();
        this.bottmMagnet = board.getbotMagnet();
        
        

    }
    public void BallMove2(PlayerMovement velocitymMovement)
    {
        this.xVelosityp1 = velocitymMovement.getxVelosityp1();
        this.yVelosityp1 = velocitymMovement.getyVelosityp1();
        this.xVelosityp2 = velocitymMovement.getxVelosityp2();
        this.yVelosityp2 = velocitymMovement.getyVelosityp2();
    }

    public void collision()
    {
    xVelosity = 0;
    yVelosity = 0;
    
        if (player1.collides(ball))
        {
            deflectp1();
            ball.move(0, yVelosity);
        }
        if (player2.collides(ball))
        {
            ball.move(xVelosityp2, yVelosityp2);
            //deflect();
        }
        if (ball.collides(middleMagnet))
        {
            middleMagnet.move(5, 0);
            //deflect();
        }
        if (ball.collides(topManget))
        {
           //deflect();
        }
        if (ball.collides(bottmMagnet))
        {
           //deflect();
        }
    }
    
    public void deflectp1()
    {
    // The position and speed of each of the two balls in the x and y axis before b
    // Calculate initial momentum of the balls... We assume unit mass here.
    double p1InitialMomentum = Math.sqrt(xVelosityp1 * xVelosityp1 + yVelosityp1 * yVelosityp1);
    double p2InitialMomentum = Math.sqrt(xVelosity * xVelosity + yVelosity * yVelosity);
    // calculate motion vectors
    double[] p1Trajectory = {xVelosityp1, yVelosityp1};
    double[] p2Trajectory = {xVelosity, yVelosity};
    // Calculate Impact Vector
    double[] impactVector = {player2.getXPosition() - player1.getXPosition(), ball.getYPosition() - ball.getYPosition()};
    double[] impactVectorNorm = normalizeVector(impactVector);
    // Calculate scalar product of each trajectory and impact vector
    double p1dotImpact = Math.abs(p1Trajectory[0] * impactVectorNorm[0] + p1Trajectory[1] * impactVectorNorm[1]);
    double p2dotImpact = Math.abs(p2Trajectory[0] * impactVectorNorm[0] + p2Trajectory[1] * impactVectorNorm[1]);
    // Calculate the deflection vectors - the amount of energy transferred from one ball to the other in each axis
    double[] p1Deflect = { -impactVectorNorm[0] * p2dotImpact, -impactVectorNorm[1] * p2dotImpact };
    double[] p2Deflect = { impactVectorNorm[0] * p1dotImpact, impactVectorNorm[1] * p1dotImpact };
    // Calculate the final trajectories
    double[] p1FinalTrajectory = {p1Trajectory[0] + p1Deflect[0] - p2Deflect[0], p1Trajectory[1] + p1Deflect[1] - p2Deflect[1]};
    double[] p2FinalTrajectory = {p2Trajectory[0] + p2Deflect[0] - p1Deflect[0], p2Trajectory[1] + p2Deflect[1] - p1Deflect[1]};
    // Calculate the final energy in the system.
    double p1FinalMomentum = Math.sqrt(p1FinalTrajectory[0] * p1FinalTrajectory[0] + p1FinalTrajectory[1] * p1FinalTrajectory[1]);
    double p2FinalMomentum = Math.sqrt(p2FinalTrajectory[0] * p2FinalTrajectory[0] + p2FinalTrajectory[1] * p2FinalTrajectory[1]);
   
    // Scale the resultant trajectories if we've accidentally broken the laws of physics.
    double mag = (p1InitialMomentum + p2InitialMomentum) / (p1FinalMomentum + p2FinalMomentum);
    // Calculate the final x and y speed settings for the two balls after collision.
    xVelosityp1 = p1FinalTrajectory[0] * mag;
    yVelosityp1 = p1FinalTrajectory[1] * mag;
    xVelosity = p2FinalTrajectory[0] * mag;
    yVelosity = p2FinalTrajectory[1] * mag;
    }
    /**
    * Converts a vector into a unit vector.
    * Used by the deflect() method to calculate the resultnt direction after a collision.
    */
    private double[] normalizeVector(double[] vec)
    {
    double mag = 0.0;
    int dimensions = vec.length;
    double[] result = new double[dimensions];
    for (int i=0; i < dimensions; i++)
    mag += vec[i] * vec[i];
    mag = Math.sqrt(mag);
    if (mag == 0.0)
    {
    result[0] = 1.0;
    for (int i=1; i < dimensions; i++)
    result[i] = 0.0;
    }
    else
    {
    for (int i=0; i < dimensions; i++)
    result[i] = vec[i] / mag;
    }
    return result;
 }
 
 public double addxvelostiy()
 {
     xVelosity = xVelosity + 0.01;
     
     return xVelosity;
     
 }
 public double addyvelocity()
 {
     yVelosity = yVelosity + 0.01;
     return yVelosity;
 }
}