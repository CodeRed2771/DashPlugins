package plugin;

import com.coderedrobotics.dashboard.communications.DSMListener;
import com.coderedrobotics.dashboard.communications.DataStream;
import com.coderedrobotics.dashboard.communications.DataStreamingModule;
import com.coderedrobotics.dashboard.communications.Packet;
import com.coderedrobotics.dashboard.communications.SynchronizedRegisterArray;

/**
 *
 * @author Austin
 */
public class DebugConsole extends javax.swing.JPanel implements DSMListener {

    DataStreamingModule dataStreamingModule;
    SynchronizedRegisterArray synchronizedRegisterArray;

    /**
     * Creates new form DebugConsole
     */
    public DebugConsole() {
        initComponents();
    }

    public void init(DataStreamingModule dataStreamingModule,
            SynchronizedRegisterArray synchronizedRegisterArray) {
        this.dataStreamingModule = dataStreamingModule;
        this.synchronizedRegisterArray = synchronizedRegisterArray;
        dataStreamingModule.addDSMListener(this);
    }

    @Override
    public void alertToDSMUpdates() {
        DataStream ds = dataStreamingModule.getStream("DEBUG");
        if (ds != null) {
            String s = "";
            Packet[] p = ds.getPackets();
            for (int i = 0; i < p.length; i++) {
                s = ((char) p[i].val) + s;
            }
            jTextArea1.setText(s);
        }
    }

    @Override
    public void alertToNewStreams() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        debugChannel = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setText("Debug Channel");

        debugChannel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                debugChannelStateChanged(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(debugChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(debugChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void debugChannelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_debugChannelStateChanged
        synchronizedRegisterArray.setRegister("DEBUGCHANNEL",
                Double.parseDouble(debugChannel.getValue().toString()));
    }//GEN-LAST:event_debugChannelStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner debugChannel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}