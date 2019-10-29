public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;   //Its current velocity in the x direction
    public double yyVel;   //Its current velocity in the y direction
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /** Initialize an identical Planet object (copy) */
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));
    }

    public double calcForceExertedBy(Planet p){
        return (G*mass*p.mass)/(calcDistance(p)*calcDistance(p));
    }

    public double calcForceExertedByX(Planet p){
        double totalForce = calcForceExertedBy(p);
        return totalForce*(p.xxPos-xxPos)/calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        double totalForce = calcForceExertedBy(p);
        return totalForce*(p.yyPos-yyPos)/calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] planets){
        double netForce = 0;
        for(Planet p : planets){
            if(this.equals(p)){continue;}
            netForce += calcForceExertedByX(p);
        }
        return netForce;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double netForce = 0;
        for(Planet p : planets){
            if(this.equals(p)){continue;}

            netForce += calcForceExertedByY(p);
        }
        return netForce;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX/mass;
        double aY = fY/mass;
        xxVel = xxVel + dt*aX;
        yyVel = yyVel + dt*aY;
        xxPos = xxPos + dt*xxVel;
        yyPos = yyPos + dt*yyVel;
    }


    public static void main(String[] args) {
        Planet samh = new Planet(1,0,0,0,10,"");
        Planet aegir = new Planet(3,3,0,0,5,"");
        Planet rocinante = new Planet(5,-3,0,0,50,"");
        Planet[] planets = {samh, aegir, rocinante};

        System.out.println(samh.calcForceExertedBy(rocinante));
        System.out.println(samh.calcForceExertedByX(rocinante));
        System.out.println(samh.calcNetForceExertedByX(planets));
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Planet squirrel = new Planet(0,0,3,5,1,"");
        squirrel.update(1,-5,-2);
        System.out.println(squirrel.xxVel+","+squirrel.yyVel);
        System.out.println(squirrel.xxPos+","+squirrel.yyPos);
    }

}
