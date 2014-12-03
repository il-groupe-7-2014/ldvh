package ihm.graphed;
import java.util.ArrayList;


/**
   An edge that is shaped like a line with up to 
   three segments with an arrowhead
*/
public class ClassRelationshipEdge extends SegmentedLineEdge
{
   /**
      Constructs a straight edge.
   */
   public ClassRelationshipEdge()
   {
      bentStyle = BentStyle.STRAIGHT;
   }

   /**
      Sets the bentStyle property
      @param newValue the bent style
   */
   public void setBentStyle(BentStyle newValue) { bentStyle = newValue; }
   /**
      Gets the bentStyle property
      @return the bent style
   */
   public BentStyle getBentStyle() { return bentStyle; }
   
   public ArrayList getPoints()
   {
      return bentStyle.getPath(getStart().getBounds(),
         getEnd().getBounds());
   }

   private BentStyle bentStyle;
}
