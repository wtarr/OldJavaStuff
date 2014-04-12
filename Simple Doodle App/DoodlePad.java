import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DoodlePad extends JFrame {

   //=========
   //Variables
   //=========
    static boolean drawRect = true;
    static boolean drawCircle = false;
    static boolean drawEllipse = false;
    static boolean drawFree = false;

    static Color the_Color_is = Color.BLACK;

    static boolean fillIt = false;

    static int scrollerValue = 2;
    JLabel lblSize = new JLabel("Size: 2");

    static JLabel X = new JLabel("X: ");
    static JLabel Y = new JLabel("Y: ");


    //==================
    //Constructor
    //==================
    public DoodlePad( ) {
        super("Draw stuff"); //Name it
        Container content = getContentPane( );
        content.setLayout(new BorderLayout( ));
        final DrawPad drawPad = new DrawPad( );
        //JPanel DPad = new JPanel();
        //DPad.add(drawPad);
        content.add(drawPad, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //============
        //Clear - Exit
        //============

        //Clear button
        JPanel p = new JPanel();
        JButton clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(90, 35));
        clearButton.addActionListener(new ActionListener( ) {
        public void actionPerformed(ActionEvent e) {
            drawPad.clear( );
                }
        });
        p.add(clearButton);

        //Exit Button
         JPanel ex = new JPanel( );
        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(90, 35));
        exitButton.addActionListener(new ActionListener( ) {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
                        }
        });
        ex.add(exitButton);

         //Add the two buttons to a single panel
        JPanel buttons = new JPanel();
        buttons.add(ex);
        buttons.add(p);


        //==========
        //The shapes
        //==========

        //Rectangle radio button
        JPanel c = new JPanel();
        final JRadioButton rectRBtn = new JRadioButton("Rectangle", true);
        rectRBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

               if (rectRBtn.isSelected()){
                   drawRect = true;
                   drawCircle = false;
                   drawEllipse = false;
                   drawFree = false;
               } 

           }
           });
        c.add(rectRBtn);

      

        //Circle radio button
        JPanel d = new JPanel();
        final JRadioButton circleRBtn = new JRadioButton("Circle", false);
        circleRBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

               if (circleRBtn.isSelected()){
                   drawRect = false;
                   drawCircle = true;
                   drawEllipse = false;
                   drawFree = false;
           }
           } //ActionPerformed
           });
        d.add(circleRBtn);

        //Ellipse radio button
        JPanel e = new JPanel();
        final JRadioButton ellipseRBtn = new JRadioButton("Ellipse", false);
        ellipseRBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

               if (ellipseRBtn.isSelected()){
                   drawRect = false;
                   drawCircle = false;
                   drawEllipse = true;
                   drawFree = false;
               }

           }
           });
        e.add(ellipseRBtn);

         //Freehand radio button
        JPanel f = new JPanel();
        final JRadioButton freeRBtn = new JRadioButton("Freehand", false);
        freeRBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

               if (freeRBtn.isSelected()){
                   drawRect = false;
                   drawCircle = false;
                   drawEllipse = false;
                   drawFree = true;

               }
           }

        });
        f.add(freeRBtn);

        ButtonGroup gp1 = new ButtonGroup();
        gp1.add(rectRBtn);
        gp1.add(circleRBtn);
        gp1.add(ellipseRBtn);
        gp1.add(freeRBtn);

        JPanel shape = new JPanel(new GridLayout(2, 2));
        javax.swing.border.Border TitledBorder = BorderFactory.createTitledBorder("Shape"); // A padded border
        shape.setBorder(TitledBorder);
        shape.add(rectRBtn);
        shape.add(circleRBtn);
        shape.add(ellipseRBtn);
        shape.add(freeRBtn);
        
        //===================
        //Color radio buttons
        //===================
        
        //Black radio button
        JPanel panelBlack = new JPanel();
        final JRadioButton blackRBtn = new JRadioButton("Black", true);
        blackRBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

             if (blackRBtn.isSelected()){
                  the_Color_is = Color.BLACK;
             }

           }
           });
        panelBlack.add(blackRBtn);

      

        //Red radio button
        JPanel panelRed = new JPanel();
        final JRadioButton redRBtn = new JRadioButton("Red", false);
        redRBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

               the_Color_is = Color.RED;

           }
           });
        panelRed.add(redRBtn);

        //White radio button
        JPanel panelWhite = new JPanel();
        final JRadioButton whiteRBtn = new JRadioButton("White", false);
        whiteRBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

           the_Color_is = Color.WHITE;

           }
           });
        panelWhite.add(whiteRBtn);
        
         //Green radio button
        JPanel panelGreen = new JPanel();
        final JRadioButton greenRBtn = new JRadioButton("Green", false);
        greenRBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

           the_Color_is = Color.GREEN;

           }
           });
        panelGreen.add(greenRBtn);

        //Yellow radio button
        JPanel panelYellow = new JPanel();
        final JRadioButton yellowRBtn = new JRadioButton("Yellow", false);
        yellowRBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

               the_Color_is = Color.YELLOW;

           }
           });
         panelYellow.add(yellowRBtn);   
        
        //Blue radio button
        JPanel panelBlue = new JPanel();
        final JRadioButton blueRBtn = new JRadioButton("Blue", false);
        blueRBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

           the_Color_is = Color.BLUE;

           }
           });
        panelBlue.add(blueRBtn);  

        //Color groupbox
        ButtonGroup gp2 = new ButtonGroup();
        gp2.add(blackRBtn);
        gp2.add(redRBtn);
        gp2.add(whiteRBtn);
        gp2.add(greenRBtn);
        gp2.add(yellowRBtn);
        gp2.add(blueRBtn);

        JPanel color = new JPanel(new GridLayout(3, 2));
        javax.swing.border.Border TitledColorBorder = BorderFactory.createTitledBorder("Color"); // A padded border
        color.setBorder(TitledColorBorder);
        color.add(blackRBtn);
        color.add(redRBtn);
        color.add(whiteRBtn);
        color.add(greenRBtn);
        color.add(yellowRBtn);
        color.add(blueRBtn);

        //==================
        //Drawing properties
        //==================

        final JCheckBox fill = new JCheckBox("Fill Shape", false);
        fill.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){

           if (fill.isSelected()){

               fillIt = true;

           } else if (fillIt == true){

               fillIt = false;

           }

           }
           });

        JSlider size = new JSlider(JSlider.HORIZONTAL, 0, 100, 2);
        size.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if(!source.getValueIsAdjusting()){
                scrollerValue = (int)source.getValue();
                lblSize.setText("Pen Size: " + scrollerValue);
            }
            }
        });

        
        JPanel properties = new JPanel(new GridLayout(3, 1));
        javax.swing.border.Border TitledPropertiesBorder = BorderFactory.createTitledBorder("Drawing Properties"); // A padded border
        properties.setBorder(TitledPropertiesBorder);
        properties.add(fill);
        properties.add(size);
        properties.add(lblSize);

        //========
        //X Coords
        //Y Coords
        //========
        JPanel CoOrds = new JPanel(new GridLayout(2, 1));
        javax.swing.border.Border TitledCoOrdsBorder = BorderFactory.createTitledBorder("Co-Ordinates"); // A padded border
        CoOrds.setBorder(TitledCoOrdsBorder);
        CoOrds.add(X);
        CoOrds.add(Y);



        //==========
        //Main panel
        //==========
        JPanel SuperMainPanel = new JPanel(new GridLayout(5, 1));
        SuperMainPanel.add(shape);
        SuperMainPanel.add(color);
        SuperMainPanel.add(properties);
        SuperMainPanel.add(CoOrds);
        SuperMainPanel.add(buttons);

        content.add(SuperMainPanel, BorderLayout.WEST);
        setSize(800, 500);
        setLocation(100, 100);
        addWindowListener(new WindowAdapter( ) {

        public void windowClosing(WindowEvent e) {
        System.exit(0);
        }
        });
        setVisible(true);

        } //Constructor


        public static void main(String[] args) {
            new DoodlePad( );
        }
        } // end of class DoodlePad

//==============================================================
//============================DRAW PAD =========================
//==============================================================
class DrawPad extends JComponent {

        Image image;
        Graphics2D graphics2D;
        int currentX, currentY, oldX, oldY, relX, relY;
        
        public DrawPad( ) {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter( ) {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX( );
                oldY = e.getY( );
            }
        });

        addMouseListener(new MouseAdapter( ) {
            public void mouseReleased(MouseEvent e) {
                relX = e.getX( );
                relY = e.getY( );

                int rWidth = relX - oldX;
                int rHeight = relY - oldY;

                if (DoodlePad.drawRect == true){

                     //To fill or not to fill that is the question
                    if (DoodlePad.fillIt == true){

                    graphics2D.setPaint(DoodlePad.the_Color_is);
                    graphics2D.setStroke(new BasicStroke(DoodlePad.scrollerValue));
                    graphics2D.fillRect(oldX, oldY, rWidth, rHeight);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                    
                    } else if (DoodlePad.fillIt == false) {
                    
                    graphics2D.setPaint(DoodlePad.the_Color_is);
                    graphics2D.setStroke(new BasicStroke(DoodlePad.scrollerValue));
                    graphics2D.drawRect(oldX, oldY, rWidth, rHeight);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                   

                    } //To fill 

                } //if RECTANGLE
                
                //------
                //CIRCLE
                //------

                    if (DoodlePad.drawCircle == true){

                    //To fill or not to fill that is the question
                    if (DoodlePad.fillIt == true){

                    graphics2D.setPaint(DoodlePad.the_Color_is);
                    graphics2D.setStroke(new BasicStroke(DoodlePad.scrollerValue));
                    graphics2D.fillOval(oldX, oldY, rWidth, rWidth);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;

                    } else if (DoodlePad.fillIt == false) {

                    graphics2D.setPaint(DoodlePad.the_Color_is);
                    graphics2D.setStroke(new BasicStroke(DoodlePad.scrollerValue));
                    graphics2D.drawOval(oldX, oldY, rWidth, rWidth);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;


                    } //To fill

                } //if CIRCLE

                //------------
                //Draw Ellipse
                //------------

                
                    if (DoodlePad.drawEllipse == true){

                    //To fill or not to fill that is the question
                    if (DoodlePad.fillIt == true){

                    graphics2D.setPaint(DoodlePad.the_Color_is);
                    graphics2D.setStroke(new BasicStroke(DoodlePad.scrollerValue));
                    graphics2D.fillOval(oldX, oldY, rWidth, rHeight);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;

                    } else if (DoodlePad.fillIt == false) {

                    graphics2D.setPaint(DoodlePad.the_Color_is);
                    graphics2D.setStroke(new BasicStroke(DoodlePad.scrollerValue));
                    graphics2D.drawOval(oldX, oldY, rWidth, rHeight);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;


                    } //Fill

                } //if Ellipse

            } //mouse released
        });


        addMouseMotionListener(new MouseMotionAdapter( ) {
        public void mouseDragged(MouseEvent e) {
            currentX = e.getX( );
            currentY = e.getY( );

            if (DoodlePad.drawFree == true){
            if (graphics2D != null)
            graphics2D.setPaint(DoodlePad.the_Color_is);
            graphics2D.setStroke(new BasicStroke(DoodlePad.scrollerValue));
            graphics2D.fillOval(currentX, currentY, DoodlePad.scrollerValue, DoodlePad.scrollerValue);
            repaint( );
            oldX = currentX;
            oldY = currentY;
            }//if
            } //mouse dragged
            });

       //Keep track of coordinates
       addMouseMotionListener(new MouseMotionAdapter() {
       public void mouseMoved(MouseEvent e) {
       DoodlePad.X.setText("X: " + e.getX());
       DoodlePad.Y.setText("Y: " + e.getY());
       }
            });


          } //Constructor








          public void paintComponent(Graphics g) {
            if (image == null) {
            image = createImage(getSize().width, getSize( ).height);
            graphics2D = (Graphics2D)image.getGraphics( );
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
            clear( );
            }

            g.drawImage(image, 0, 0, null);

            }

            public void clear( ) {
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize( ).height);
            graphics2D.setPaint(Color.black);
            repaint( );
            }


}
