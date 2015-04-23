import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by shrikant on 4/23/2015.
 */
public class FBIAgentTest {


    @Test
    public void shouldPutSecurityIfSecurityNeededMessageIsReceived()
    {
        FBIAgent fbiAgent = new FBIAgent();
        fbiAgent.update(null, new Boolean(true));
        assertEquals(fbiAgent.checkSecurityNeededInParkingLot(), "NEED SECURITY");
    }

    @Test
    public void shouldRemoveSecurityIfNoSecurityMessageIsReceived()
    {
        FBIAgent fbiAgent = new FBIAgent();
        fbiAgent.update(null, new Boolean(false));
        assertEquals(fbiAgent.checkSecurityNeededInParkingLot(), "NO SECURITY");
    }
}