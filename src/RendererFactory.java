/**
 * Represents a code for the RenderFactory.
 * Using this method we can use all the different renders.
 * @author Gabi Album
 */
public class RendererFactory 
{
    /**
     * The method builds the render that needs to be in use.
     * @param renderType The type of player that need to be in use.
     * @return A new render variable.
     */
    public Renderer buildRenderer(String renderType){
        switch(renderType){
            case "console":
            return new ConsoleRenderer();
            
            case "none":
            return new VoidRenderer();
            
            default:
            return null;
        } // end of switch
    } // end of method buildPlayer
} //end of class RendererFactory
