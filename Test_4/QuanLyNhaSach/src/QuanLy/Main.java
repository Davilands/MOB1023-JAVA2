package QuanLy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dangt
 */
public class Main extends javax.swing.JFrame {

    List<TraSua> list = new ArrayList<>();
    DefaultTableModel model;
    int index = 0;

    public Main() {
        initComponents();
        loadData();
        fillToTable();

    }

    public boolean validate_SL(int soLuong) {
        try {
            if (soLuong < 1 || soLuong > 20) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng từ 1-20: ");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng không phù hợp: ");
            return false;
        }
        return true;
    }

    public void loadData() {
        model = new DefaultTableModel();
        //list.add(new TraSua("NC98","Tra Sua Dau",5,15000));

        //Tạo các cột
        model.addColumn("Mã Thức Uống");
        model.addColumn("Tên Thức Uống");
        model.addColumn("Số Lượng");
        model.addColumn("Đơn Giá");

        //Thêm dòng dữ liệu {
        for (TraSua index : list) {
            model.addRow(new Object[]{
                index.getMaThucUong(), index.getTenThucUong(), index.getSoLuong(), index.getDonGia()
            });
        }

        //Đẩy Data từ Model --> Table
        //tblList.setModel(model);
    }

    public void fillToTable() {
        for (TraSua index : list) {
            model.addRow(new Object[]{
                index.getMaThucUong(), index.getTenThucUong(), index.getSoLuong(), index.getDonGia()
            });
        }
        //tblList.setModel(model);
        if (tblList.getRowCount() < 1) {
            model.setRowCount(0);
        } else {
            tblList.setModel(model);
        }
    }

    public void Luu() {
        int row = tblList.getRowCount();
        System.out.println(row);
        try {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu không?",
                    "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.out.println(row);
                if (row == 0) {
                    JOptionPane.showConfirmDialog(this, "Lưu Thất Bại!", "Lỗi!",
                            JOptionPane.ERROR_MESSAGE);
                    //System.exit(0);
                } else {
                    System.out.println(list);
                    System.out.println(row);
                    FileOutputStream fos = new FileOutputStream("src\\data\\QuanLy_TraSua.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(list);
                    oos.flush();
                    fos.flush();
                    oos.close();
                    JOptionPane.showMessageDialog(this, "Lưu thành công!");
                }
            } else {
                //System.exit(0);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
            System.out.println(e);
        }
    }

    public void Open() {
        try {
            FileInputStream fis = new FileInputStream("src\\data\\QuanLy_TraSua.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<TraSua>) ois.readObject();
            JOptionPane.showMessageDialog(this, "Đọc File thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    public void Them() {
        boolean checkMTU = true;
        try {
            for (TraSua x: list) {
                if (x.maThucUong.equalsIgnoreCase((txtMaThucUong.getText()))){
                    JOptionPane.showMessageDialog(this, "Mã thức uống đã tồn tại ");
                    checkMTU = false;
                    break;
                }
            }
            if (validate_SL(Integer.valueOf(txtSoLuong.getText())) && checkMTU==true ) {
                list.add(new TraSua(txtMaThucUong.getText(), txtTenThucUong.getText(), Integer.valueOf(txtSoLuong.getText()), Float.valueOf(txtDonGia.getText())));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng không phù hợp: ");
        }
        fillToTable();
    }

    public void ShowField(int index) {
        txtMaThucUong.setText(tblList.getValueAt(index, 0).toString());
        txtTenThucUong.setText(tblList.getValueAt(index, 1).toString());
        txtSoLuong.setText(tblList.getValueAt(index, 2).toString());
        txtDonGia.setText(tblList.getValueAt(index, 3).toString());
        txtThanhTien.setText("");
    }

    public void sortGia() {
        Comparator<TraSua> comp = new Comparator<TraSua>() {
            public int compare(TraSua s1, TraSua s2) {
                if (s1.donGia > s2.donGia) {
                    return 1;
                }
                if (s1.donGia < s2.donGia) {
                    return -1;
                }
                return 0;  //s1.diemTB = s2.diemTB
            }
        };
        Collections.sort(list, comp);            //tăng dần
        //Collections.sort(list, comp.reversed()); //giảm dần
    }

    public void Find() {
        try {
            String inputFind = JOptionPane.showInputDialog("Nhập Mã đơn hàng cần tìm: ");
            boolean isFind = false;
            for (TraSua x : list) {
                if (x.getMaThucUong().equalsIgnoreCase(inputFind)) {
                    index = list.indexOf(x);
                    isFind = true;
                    break;
                }
            }
            if (inputFind != null) {
                if (!isFind) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy đơn hàng có Mã: " + inputFind);

                } else {
                    JOptionPane.showMessageDialog(this, "Tìm thấy có đơn hàng với Mã: " + inputFind);
                    ShowField(index);
                    tblList.setRowSelectionInterval(index, index);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        txtMaThucUong = new javax.swing.JTextField();
        txtTenThucUong = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        btnTinhTien = new javax.swing.JButton();
        btnLuuFile = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("QUẢN LÝ QUÁN TRÀ SỮA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 26, 324, 46));

        jLabel2.setText("Thành Tiền");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 90, 20));

        jLabel3.setText("Mã Thức Uống");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 100, 20));

        jLabel4.setText("Tên Thức Uống");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 100, 20));

        jLabel5.setText("Số Lượng");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 100, 20));

        jLabel6.setText("Đơn Giá");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 70, 20));
        getContentPane().add(txtThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 160, 30));
        getContentPane().add(txtMaThucUong, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 260, 30));
        getContentPane().add(txtTenThucUong, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 260, 30));
        getContentPane().add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 260, 30));
        getContentPane().add(txtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 260, 30));

        btnTinhTien.setText("Tính Tiền");
        btnTinhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhTienActionPerformed(evt);
            }
        });
        getContentPane().add(btnTinhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 80, 30));

        btnLuuFile.setText("Lưu File");
        btnLuuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuFileActionPerformed(evt);
            }
        });
        getContentPane().add(btnLuuFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 90, 30));

        jButton3.setText("Làm mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 80, 30));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 80, 30));

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        getContentPane().add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 80, 30));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 80, 30));

        btnFind.setText("Tìm kiếm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        getContentPane().add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 90, 30));

        btnSort.setText("Xếp Theo Đơn Giá");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });
        getContentPane().add(btnSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 90, 30));

        jButton9.setText("Đọc File");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 90, 30));

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 700, 110));

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 70, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        model.setRowCount(0);
        Them();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuFileActionPerformed
        Luu();
    }//GEN-LAST:event_btnLuuFileActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Open();
        model.setRowCount(0);
        fillToTable();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtMaThucUong.setText("");
        txtTenThucUong.setText("");
        txtDonGia.setText("");
        txtSoLuong.setText("");
        txtThanhTien.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        index = tblList.getSelectedRow();
        ShowField(index);
    }//GEN-LAST:event_tblListMouseClicked

    private void btnTinhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhTienActionPerformed
        float topping = 0;
        float tongTien = Float.valueOf(tblList.getValueAt(index, 2).toString()) * Float.valueOf(tblList.getValueAt(index, 3).toString());
        if (jcbTranChau.isSelected() == true) {
            topping = topping + 10000;
        }
        if (jcbBanhFlan.isSelected() == true) {
            topping = topping + 10000;
        }
        if (jcbRauCau.isSelected() == true) {
            topping = topping + 5000;
        }
        tongTien = tongTien + topping;
        txtThanhTien.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_btnTinhTienActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tblList.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần xóa từ bảng!");
        } else {
            int ketQua = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không?", "Xóa nhân viên", JOptionPane.YES_OPTION);
            if (ketQua == JOptionPane.YES_OPTION) {
                index = tblList.getSelectedRow();
                list.remove(index);
                model.setRowCount(0);
                fillToTable();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            }
        }
        


    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        sortGia();
        model.setRowCount(0);
        fillToTable();
    }//GEN-LAST:event_btnSortActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        Find();
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        //index = tblList.getSelectedRow();
        for (TraSua x: list) {
            if (x.maThucUong.equalsIgnoreCase(txtMaThucUong.getText())){
                x.donGia = Float.valueOf(txtDonGia.getText());
                x.soLuong = Integer.valueOf( txtSoLuong.getText() );
                x.tenThucUong = txtTenThucUong.getText();
                model.setRowCount(0);
                fillToTable();
                break;
            }
        }
        
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Bill bill = new Bill(txtMaThucUong.getText(), txtTenThucUong.getText(), txtSoLuong.getText(), txtDonGia.getText());
        bill.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnLuuFile;
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTinhTien;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaThucUong;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenThucUong;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
