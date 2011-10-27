/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.event.ActionEvent;
import org.icefaces.component.fileentry.*;
import org.icefaces.component.fileentry.FileEntryResults.FileInfo;

/**
 *
 * @author Zeyckler
 */
public class SubirArchivoBean {

    /** Creates a new instance of SubirArchivoBean */
    public SubirArchivoBean() {
    }

    public void subirLogo(ActionEvent event) {
        FileEntry fileentry = (FileEntry) event.getSource();
        FileEntryResults resultado = fileentry.getResults();
        for (FileInfo fileinfo : resultado.getFiles()) {
            if (fileinfo.isSaved()) {
                String a = fileinfo.getFile().getAbsolutePath();
                System.out.println("----------------------->>>>>>>>>>>"+a);
            }
        }


    }
}
