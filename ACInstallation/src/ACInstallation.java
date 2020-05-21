
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/*
 Made by Student Names : Tajinder Pal Singh & Mohit Redhu
                Student ID -12095732 & 12100962
 */
public class ACInstallation extends javax.swing.JFrame {

    public String data; //String data type for dat variable
    String[] options = new String[100]; //array of options
    private Details[] details = new Details[10000]; // array of details
    public int current = 0; //int data type of current variable

    /**
     * Creates new form ACInstallation
     * 
     */
    
    //constructor
    public ACInstallation() {
        super("Ac Installation App  "); // heading
                
        initComponents();
        displayTextArea.setVisible(false);
    }

    //save data function throwing FileNotFoundException and IOException
    
    private void saveData() throws FileNotFoundException, IOException {
        readData(); //function for reading data from file
        File fout = new File("data.txt"); //creating file data.txt for storing details 
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.append(data);
        
        //loop for storing all the data in the file
        //for (int i = 0; i < current; i++) 
        {
            bw.append(details[current-1].toString());
            bw.newLine();
        }
        bw.close();
    }

    //displayAll function to display all the data showing IOException
    private void displayAll() throws IOException {
        readData();
        displayTextArea.setVisible(true);
        displayTextArea.setText("");
        displayTextArea.setText(data);
    }

    //Exit button coding 
    private void exit() {
        
        //displaying exut message when exit button is pressed
        JOptionPane.showMessageDialog(rootPane, "Thank You for using ACInstallation System", "AC Installation System", HEIGHT);
        System.exit(0);
    }

    //coding for clear button
    private void clear() {
        tName.setText(""); //clearing the Name field
        tPhone.setText(""); //clearing the Phone number field
        bAdd.setText(""); //clearing the Address field
        bHp.setText(""); //clearing the Hp field
        bZone.setText(""); //clearing the Zone field
        bOutlet.setText(""); //clearing the Outlet field
        iStartDate.setText(""); //clearing the Start Date field
        iStartMonth.setText(""); //clearing the Start Month field
        iStartYear.setText("");  //clearing the Start Year field
        iEndDate.setText("");  //clearing the End date field
        iEndMonth.setText(""); //clearing the End Month field
        iEndYear.setText("");  //clearing the End Year field
    }

    //save name function throwing IOException
    private void saveName() throws IOException {
        readName(); // reading the name 
        int a = 0; //int data type for variable a
        
        // using for loop for getting data from options array
        for (int i = 0; i < options.length; ++i) {
            if (tName.getText().equals(options[i])) {
                a = 1;
            } else {
            }
        }
        System.out.print("a = " + a);
        if (a != 1) {
            File fout = new File("names.txt"); // creating file for saving the technician name
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.append(tName.getText() + "\n");
            
            //for loop for saving technician name in names.txt file
            for (int i = 0; i < options.length; i++) {
                if (options[i] != null && options[i] != "") {
                    bw.append(options[i]);
                }
                bw.newLine();
            }
            bw.close();
        }
    }

    //read name function throwing FileNotFoundException and IOException
    private void readName() throws FileNotFoundException, IOException {
        for (int a = 0; a < 100; ++a) {
            options[a] = "";
        }
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("names.txt"));
        String line = reader.readLine();
        int i = 0;
        while (i < 100) {
            options[i] = line;
            line = reader.readLine();
            i++;
        }
        reader.close();
    }

    //coding for enter button
    private void enter() throws IOException {
        
  
        if (tName.getText().compareTo("") == 0 || tName.getText().matches("[0-9]+")) {
            
         //error dialogue box if no name is entered or name in entered incorrectly
            JOptionPane.showMessageDialog(rootPane, "Please Enter the Name", "AC Installation", HEIGHT);
            tName.requestFocus(); //returning focus to name field
            
        } else if (tPhone.getText().compareTo("") == 0 || !tPhone.getText().matches("[0-9]+") || tPhone.getText().length() != 10) {
            
             //error dialogue box if no phone number is entered or phone number in entered incorrectly
            JOptionPane.showMessageDialog(rootPane, "Please Enter the Phone No corectly", "AC Installation", HEIGHT);
            tPhone.requestFocus();//returning focus to phone number field
            
             //error dialogue box if no address is entered or address in entered incorrectly
        } else if (bAdd.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter the Address", "AC Installation", HEIGHT);
            bAdd.requestFocus();//returning focus to address field
            
             //error dialogue box if no Hp is entered or Hp in entered incorrectly
        } else if (bHp.getText().compareTo("") == 0 || !bHp.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter the Horse Power", "AC Installation", HEIGHT);
            bHp.requestFocus(); //returning focus to Hp field
            
             //error dialogue box if no Zone is entered or zone in entered incorrectly
        } else if (bZone.getText().compareTo("") == 0 || !bZone.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter the Zone", "AC Installation", HEIGHT);
            bZone.requestFocus(); //returning focus to Zone field
            
             //error dialogue box if no outlet is entered or outlet in entered incorrectly
        } else if (bOutlet.getText().compareTo("") == 0 || !bOutlet.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter the Outlet", "AC Installation", HEIGHT);
            bOutlet.requestFocus(); //returning focus to Outlet field
            
             //error dialogue box if no Start Year is entered or Start Year in entered incorrectly
        } else if (iStartYear.getText().compareTo("") == 0 || iStartMonth.getText().compareTo("") == 0 || iStartDate.getText().compareTo("") == 0 || !iStartYear.getText().matches("[0-9]+") || !iStartMonth.getText().matches("[0-9]+") || !iStartDate.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter the Start Date", "AC Installation", HEIGHT);
            iStartYear.requestFocus(); //returning focus to Start Year field
            
             //error dialogue box if no End Year is entered or End Year in entered incorrectly
        } else if (iEndYear.getText().compareTo("") == 0 || iEndMonth.getText().compareTo("") == 0 || iEndDate.getText().compareTo("") == 0 || !iEndYear.getText().matches("[0-9]+") || !iEndMonth.getText().matches("[0-9]+") || !iEndDate.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter the End Date", "AC Installation", HEIGHT);
            iEndYear.requestFocus();//returning focus to End Year field
            
             //error dialogue box if no Start Year is entered incorrectly
        } else if (iStartYear.getText().length() != 4 || Integer.parseInt(iStartDate.getText()) > 31 || Integer.parseInt(iEndDate.getText()) > 31 || Integer.parseInt(iStartMonth.getText()) > 12 || Integer.parseInt(iEndMonth.getText()) > 12 || iStartMonth.getText().length() != 2 || iStartDate.getText().length() != 2 || iEndYear.getText().length() != 4 || iEndMonth.getText().length() != 2 || iEndDate.getText().length() != 2) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a valid Date", "AC Installation", HEIGHT);
            iEndYear.requestFocus();//returning focus to Start Year field
            
             //error dialogue box if End Year, date or Month is more than that of Start Year, Month and date
        } else if (Integer.parseInt(iStartYear.getText()) >= Integer.parseInt(iEndYear.getText())) {
            if (Integer.parseInt(iStartMonth.getText()) >= Integer.parseInt(iEndMonth.getText())) {
                if (Integer.parseInt(iStartDate.getText()) >= Integer.parseInt(iEndDate.getText())) {
                    JOptionPane.showMessageDialog(rootPane, "Please re-check the Dates", "AC Installation", HEIGHT);
                    iStartYear.requestFocus();//returning focus to Start Year field
                } else {
                    
                    //saving the data
                    details[current] = new Details(tName.getText(), tPhone.getText(), bAdd.getText(), bHp.getText(), bZone.getText(), bOutlet.getText(), iStartDate.getText() + "/" + iStartMonth.getText() + "/" + iStartYear.getText(), iEndDate.getText() + "/" + iEndMonth.getText() + "/" + iEndYear.getText());
                    current = current + 1;
                    saveData();
                    saveName();
                    JOptionPane.showMessageDialog(rootPane, "Data Entered", "AC Installation", HEIGHT);
                    clear();
                }

            } else {
                
                //saving the data
                details[current] = new Details(tName.getText(), tPhone.getText(), bAdd.getText(), bHp.getText(), bZone.getText(), bOutlet.getText(), iStartDate.getText() + "/" + iStartMonth.getText() + "/" + iStartYear.getText(), iEndDate.getText() + "/" + iEndMonth.getText() + "/" + iEndYear.getText());
                current = current + 1;
                saveData();
                saveName();
                JOptionPane.showMessageDialog(rootPane, "Data Entered", "AC Installation", HEIGHT);
                clear();
            }
        } else {
            
            //saving the data
            details[current] = new Details(tName.getText(), tPhone.getText(), bAdd.getText(), bHp.getText(), bZone.getText(), bOutlet.getText(), iStartDate.getText() + "/" + iStartMonth.getText() + "/" + iStartYear.getText(), iEndDate.getText() + "/" + iEndMonth.getText() + "/" + iEndYear.getText());
            current = current + 1;
            saveData();
            saveName();
            JOptionPane.showMessageDialog(rootPane, "Data Entered", "AC Installation", HEIGHT);
            clear();
        }
    }

    //coding of clear data button
    private void clearData() throws FileNotFoundException, IOException {
        File fout = new File("names.txt");
        File fout1 = new File("data.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        FileOutputStream fos1 = new FileOutputStream(fout1);
        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(fos));
        bw1.write("");
        
        //message dialogue box if data is entered
        JOptionPane.showMessageDialog(rootPane, "Data has been Cleared", "AC Installation", HEIGHT);
        bw.close();
        bw1.close();
    }

    
    //read data function throws IOException and FileNotFoundException
    private void readData() throws FileNotFoundException, IOException {
        data = "";
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("data.txt"));
        String line = reader.readLine();
        while (line != null) {
            data = data + "\n" + line;
            line = reader.readLine();
        }
        reader.close();

    }

    //showT function throws IOException
    private void showT(String tName) throws IOException {
        String tData = "";
        displayTextArea.setText("");
        readData();
        String a[] = data.split("-------------------------------------------------------");
        for (int i = 0; i < a.length; i++) {
            if (a[i].contains(tName)) {
                tData = tData + a[i];
            }
        }
        displayTextArea.show();
        displayTextArea.setText(tData);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tName = new javax.swing.JTextField();
        tPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bAdd = new javax.swing.JTextField();
        bHp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bZone = new javax.swing.JTextField();
        bOutlet = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        iStartYear = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        clearAll = new javax.swing.JButton();
        displayAll = new javax.swing.JButton();
        iStartMonth = new javax.swing.JTextField();
        iStartDate = new javax.swing.JTextField();
        iEndMonth = new javax.swing.JTextField();
        iEndDate = new javax.swing.JTextField();
        iEndYear = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTextArea = new javax.swing.JTextArea();
        exit1 = new javax.swing.JButton();
        addBtn1 = new javax.swing.JButton();
        addBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("BUILDING DETAILS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Phone No");

        tName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNameActionPerformed(evt);
            }
        });

        tPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPhoneActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("TECHNICIAN DETAILS");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Address");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("HP");

        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        bHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHpActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Zone");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Outlet");

        bZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZoneActionPerformed(evt);
            }
        });

        bOutlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOutletActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("INSTALLATION DETAILS");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Start Date (YYYY/MM/DD)");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("End Date (YYYY/MM/DD)");

        iStartYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iStartYearActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        clearAll.setText("Clear");
        clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllActionPerformed(evt);
            }
        });

        displayAll.setText("Display All");
        displayAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAllActionPerformed(evt);
            }
        });

        iStartMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iStartMonthActionPerformed(evt);
            }
        });

        iStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iStartDateActionPerformed(evt);
            }
        });

        iEndMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iEndMonthActionPerformed(evt);
            }
        });

        iEndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iEndDateActionPerformed(evt);
            }
        });

        iEndYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iEndYearActionPerformed(evt);
            }
        });

        displayTextArea.setEditable(false);
        displayTextArea.setColumns(20);
        displayTextArea.setRows(5);
        jScrollPane1.setViewportView(displayTextArea);

        exit1.setText("Exit");
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });

        addBtn1.setText("Search by Technician");
        addBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn1ActionPerformed(evt);
            }
        });

        addBtn2.setText("Clear All Data");
        addBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel9)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bZone, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bHp, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(iStartYear, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(iStartMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(iStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(iEndYear, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(iEndMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(iEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn1)
                                .addGap(18, 18, 18)
                                .addComponent(addBtn2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clearAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(displayAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exit1)))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(jLabel4)
                    .addContainerGap(566, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(bHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(bZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(bOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(iStartYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iStartMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(iEndYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iEndMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(clearAll)
                    .addComponent(displayAll)
                    .addComponent(exit1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn1)
                    .addComponent(addBtn2))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel4)
                    .addContainerGap(444, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 // event handler for name field
    private void tNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNameActionPerformed
        
    }//GEN-LAST:event_tNameActionPerformed

    // event handler for Phone number field
    private void tPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPhoneActionPerformed

    // event handler for address field
    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bAddActionPerformed

    // event handler for Hp field
    private void bHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bHpActionPerformed

    // event handler for Zone field
    private void bZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bZoneActionPerformed

    // event handler for outlet field
    private void bOutletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOutletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bOutletActionPerformed

    // event handler for Start Year field
    private void iStartYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iStartYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iStartYearActionPerformed

    // event handler for add button
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        try {
            // TODO add your handling code here:
            enter();
//            saveName();
        } catch (IOException ex) {
            Logger.getLogger(ACInstallation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    // event handler for clear all button
    private void clearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearAllActionPerformed

    // event handler for display all button
    private void displayAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAllActionPerformed
        try {
            // TODO add your handling code here:();
            displayAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ACInstallation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ACInstallation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_displayAllActionPerformed

    
    // event handler for Start Month field
    private void iStartMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iStartMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iStartMonthActionPerformed

    // event handler for Start Date field
    private void iStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iStartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iStartDateActionPerformed

    // event handler for End Month field
    private void iEndMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iEndMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iEndMonthActionPerformed

    // event handler for End Date field
    private void iEndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iEndDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iEndDateActionPerformed

    // event handler for End Year field
    private void iEndYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iEndYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iEndYearActionPerformed

    // event handler for exit button
    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
        // TODO add your handling code here:
        exit();
    }//GEN-LAST:event_exit1ActionPerformed

    // event handler for add button
    private void addBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn1ActionPerformed
        try {
            readName();
        } catch (IOException ex) {
            Logger.getLogger(ACInstallation.class.getName()).log(Level.SEVERE, null, ex);
        }
        JComboBox optionList = new JComboBox(options);
        optionList.setSelectedIndex(0);
        String abc;
        int selection = JOptionPane.showOptionDialog(null, optionList, "Abc", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null,
                options[5]);
        int index = optionList.getSelectedIndex();
        try {
            showT(options[index]);
        } catch (IOException ex) {
            Logger.getLogger(ACInstallation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBtn1ActionPerformed

    private void addBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn2ActionPerformed
        try {
            clearData();
        } catch (IOException ex) {
            Logger.getLogger(ACInstallation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBtn2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ACInstallation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ACInstallation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ACInstallation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ACInstallation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ACInstallation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addBtn1;
    private javax.swing.JButton addBtn2;
    private javax.swing.JTextField bAdd;
    private javax.swing.JTextField bHp;
    private javax.swing.JTextField bOutlet;
    private javax.swing.JTextField bZone;
    private javax.swing.JButton clearAll;
    private javax.swing.JButton displayAll;
    private javax.swing.JTextArea displayTextArea;
    private javax.swing.JButton exit1;
    private javax.swing.JTextField iEndDate;
    private javax.swing.JTextField iEndMonth;
    private javax.swing.JTextField iEndYear;
    private javax.swing.JTextField iStartDate;
    private javax.swing.JTextField iStartMonth;
    private javax.swing.JTextField iStartYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tName;
    private javax.swing.JTextField tPhone;
    // End of variables declaration//GEN-END:variables

}
