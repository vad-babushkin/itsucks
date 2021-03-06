/*
 * DownloadJobFileSizeRulesPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package de.phleisch.app.itsucks.gui.job.panel;

import java.util.List;

import javax.swing.JPanel;

import de.phleisch.app.itsucks.filter.download.impl.FileSizeFilter;
import de.phleisch.app.itsucks.gui.job.ifc.EditJobCapable;
import de.phleisch.app.itsucks.gui.util.FieldValidator;
import de.phleisch.app.itsucks.persistence.SerializableJobPackage;

/**
 *
 * @author  __USER__
 */
public class DownloadJobFileSizeRulesPanel extends JPanel 
		implements EditJobCapable {

	private static final long serialVersionUID = -2550810599331718712L;

	/** Creates new form DownloadJobFileSizeRulesPanel */
	public DownloadJobFileSizeRulesPanel() {
		init();
	}
	
	protected void init() {
		initComponents();
	}

	public void loadJobPackage(SerializableJobPackage pJobPackage) {
		
		FileSizeFilter fileSizeFilter = 
			(FileSizeFilter) pJobPackage.getFilterByType(FileSizeFilter.class);
		
		if (fileSizeFilter != null) {

			this.fileSizeEnableCheckBox
					.setSelected(true);

			this.fileSizeMinField
					.setText(fileSizeFilter.getMinSizeAsText());
			this.fileSizeMaxField
					.setText(fileSizeFilter.getMaxSizeAsText());
			this.fileSizeNotKnownComboBox
					.setSelectedIndex(fileSizeFilter.isAcceptWhenLengthNotSet() ? 0
							: 1);
		}
	}

	public void saveJobPackage(SerializableJobPackage pJobPackage) {

		FileSizeFilter fileSizeFilter = 
			(FileSizeFilter) pJobPackage.getFilterByType(FileSizeFilter.class);
		
		//file size filter
		if (this.fileSizeEnableCheckBox
				.isSelected()) {

			if(fileSizeFilter == null) {
				fileSizeFilter = new FileSizeFilter();
				pJobPackage.addFilter(fileSizeFilter);
			}

			fileSizeFilter
					.setMinSizeAsText(this.fileSizeMinField
							.getText().trim());
			fileSizeFilter
					.setMaxSizeAsText(this.fileSizeMaxField
							.getText().trim());

			fileSizeFilter
					.setAcceptWhenLengthNotSet(this.fileSizeNotKnownComboBox
							.getSelectedIndex() > 0 ? false : true);
		}
	}
	
	
	public List<String> validateFields() {

		FieldValidator validator = new FieldValidator();

		if (fileSizeEnableCheckBox.isSelected()) {

			String regExp = "^([-]?[0-9]{1,})[ ]*(KB|kb|MB|mb|GB|gb|$)$";

			validator.assertRegExpResult(regExp, this.fileSizeMinField
					.getText().trim(),
					"Enter a valid value for the minimum file size.");

			validator.assertRegExpResult(regExp, this.fileSizeMaxField
					.getText().trim(),
					"Enter a valid value for the maximum file size.");
		}

		return validator.getErrors();
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileSizePanel = new javax.swing.JPanel();
        fileSizeLabel = new javax.swing.JLabel();
        fileSizeEnableCheckBox = new javax.swing.JCheckBox();
        fileSizeMinLabel = new javax.swing.JLabel();
        fileSizeMinField = new javax.swing.JTextField();
        fileSizeMaxLabel = new javax.swing.JLabel();
        fileSizeMaxField = new javax.swing.JTextField();
        fileSizeUnitExplanationLabel = new javax.swing.JLabel();
        fileSizeNotKnownLabel = new javax.swing.JLabel();
        fileSizeNotKnownComboBox = new javax.swing.JComboBox();

        fileSizePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("File Size Filter"));

        fileSizeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        fileSizeLabel.setText("<html>Set file size limits to prevent ItSucks from saving certain files on the disk. To get the file size, a connection has to be opened to the server. This can be slow when the server response time is bad. It is not guranteed that the server can send the file size (eg. dynamic sites).</html>");

        fileSizeEnableCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        fileSizeEnableCheckBox.setText("Enable File Size Filter");
        fileSizeEnableCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        fileSizeEnableCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fileSizeEnableCheckBoxStateChanged(evt);
            }
        });

        fileSizeMinLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        fileSizeMinLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fileSizeMinLabel.setText("Min. file size:");
        fileSizeMinLabel.setEnabled(false);
        fileSizeMinLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        fileSizeMinField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fileSizeMinField.setText("-1");
        fileSizeMinField.setEnabled(false);

        fileSizeMaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        fileSizeMaxLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fileSizeMaxLabel.setText("Max. file size:");
        fileSizeMaxLabel.setEnabled(false);
        fileSizeMaxLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        fileSizeMaxField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fileSizeMaxField.setText("-1");
        fileSizeMaxField.setEnabled(false);

        fileSizeUnitExplanationLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        fileSizeUnitExplanationLabel.setText("<html>To disable a limit, enter -1 as value. <br>Possible units are: KB (1024 byte), MB (1024 KB) and GB (1024 MB). If no unit is given, the value is interpreted as bytes. </html>");
        fileSizeUnitExplanationLabel.setMinimumSize(new java.awt.Dimension(45, 30));

        fileSizeNotKnownLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        fileSizeNotKnownLabel.setText("In case the file size is not sent by server:");
        fileSizeNotKnownLabel.setEnabled(false);

        fileSizeNotKnownComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        fileSizeNotKnownComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Save file", "Reject File" }));
        fileSizeNotKnownComboBox.setEnabled(false);

        org.jdesktop.layout.GroupLayout fileSizePanelLayout = new org.jdesktop.layout.GroupLayout(fileSizePanel);
        fileSizePanel.setLayout(fileSizePanelLayout);
        fileSizePanelLayout.setHorizontalGroup(
            fileSizePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(fileSizePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(fileSizePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(fileSizeLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .add(fileSizePanelLayout.createSequentialGroup()
                        .add(fileSizePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(fileSizeMinLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(fileSizeMaxLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fileSizePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(fileSizeMinField)
                            .add(fileSizeMaxField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fileSizeUnitExplanationLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                    .add(fileSizePanelLayout.createSequentialGroup()
                        .add(fileSizeEnableCheckBox)
                        .add(62, 62, 62))
                    .add(fileSizePanelLayout.createSequentialGroup()
                        .add(fileSizeNotKnownLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fileSizeNotKnownComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        fileSizePanelLayout.setVerticalGroup(
            fileSizePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(fileSizePanelLayout.createSequentialGroup()
                .add(fileSizeLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(fileSizePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(fileSizePanelLayout.createSequentialGroup()
                        .add(fileSizeEnableCheckBox)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fileSizePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(fileSizeMinLabel)
                            .add(fileSizeMinField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fileSizePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(fileSizeMaxLabel)
                            .add(fileSizeMaxField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(fileSizeUnitExplanationLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(fileSizePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(fileSizeNotKnownLabel)
                    .add(fileSizeNotKnownComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(fileSizePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(fileSizePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	//GEN-FIRST:event_fileSizeEnableCheckBoxStateChanged
	private void fileSizeEnableCheckBoxStateChanged(
			javax.swing.event.ChangeEvent evt) {

		boolean enabled = fileSizeEnableCheckBox.isSelected();

		fileSizeMinLabel.setEnabled(enabled);
		fileSizeMinField.setEnabled(enabled);
		fileSizeMaxLabel.setEnabled(enabled);
		fileSizeMaxField.setEnabled(enabled);
		fileSizeNotKnownLabel.setEnabled(enabled);
		fileSizeNotKnownComboBox.setEnabled(enabled);

	}//GEN-LAST:event_fileSizeEnableCheckBoxStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JCheckBox fileSizeEnableCheckBox;
    protected javax.swing.JLabel fileSizeLabel;
    protected javax.swing.JTextField fileSizeMaxField;
    protected javax.swing.JLabel fileSizeMaxLabel;
    protected javax.swing.JTextField fileSizeMinField;
    protected javax.swing.JLabel fileSizeMinLabel;
    protected javax.swing.JComboBox fileSizeNotKnownComboBox;
    protected javax.swing.JLabel fileSizeNotKnownLabel;
    protected javax.swing.JPanel fileSizePanel;
    protected javax.swing.JLabel fileSizeUnitExplanationLabel;
    // End of variables declaration//GEN-END:variables

}