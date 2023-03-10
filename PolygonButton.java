import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class PolygonButton extends JButton implements ActionListener{
    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;
    //private MouseHandler mouseHandler;
    private PolygonCommand polygonCommand;
    private UndoManager undoManager;
    //private int pointCount = 0;
    public PolygonButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
        super("Polygon");
        this.undoManager = undoManager;
        addActionListener(this);
        view = jFrame;
        drawingPanel = jPanel;
        mouseHandler = new MouseHandler();
    }

    public void actionPerformed(ActionEvent event) {
      view.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
      // Change cursor when button is clicked
      drawingPanel.addMouseListener(mouseHandler);
    // Start listening for mouseclicks on the drawing panel
    }

      private class MouseHandler extends MouseAdapter {
        public int pointCount = 0;
        public void mouseClicked(MouseEvent event) {
          pointCount++;
          if (pointCount == 1) {
            //p = View.mapPoint(event.getPoint());
            polygonCommand = new PolygonCommand(View.mapPoint(event.getPoint()));
            undoManager.beginCommand(polygonCommand);
          } else if (pointCount == 2){
            polygonCommand.setLinePoint(View.mapPoint(event.getPoint()));
            
          }else if (pointCount == 3) {
            
            polygonCommand.setLinePoint(View.mapPoint(event.getPoint()));
            
          } else if (pointCount == 4){
            pointCount = 0;
            polygonCommand.setLinePoint(View.mapPoint(event.getPoint()));
            drawingPanel.removeMouseListener(this);
            //drawingPanel.removeMouseMotionListener(this);
            view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            undoManager.endCommand(polygonCommand);
          }
        }
    }

}
