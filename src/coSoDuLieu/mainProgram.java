package coSoDuLieu;

import java.io.File;
import java.util.Scanner;

import static coSoDuLieu.createDB.newDB;
import static coSoDuLieu.connectionSwitch.connect;
import static coSoDuLieu.connectionSwitch.disconnect;
import static coSoDuLieu.modifyTable.*;

public class mainProgram {

    static boolean currState = true;
    static File DBScanner = new File("db");
    static String[] DBList;
    static boolean dbname;

    public static void main (String[] args) {
        tableGui giaoDien = new tableGui();
        Scanner scanner = new Scanner(System.in);
        itemQuery timKiemParent = new rewardSearch();
        rewardSearch timKiem = (rewardSearch) timKiemParent;
        giaoDien.displayTableGui();

        System.out.println("Chuong trinh kiem soat khai bao co so du lieu giang vien de tai 21 cua nhom 16");
        System.out.println("------------------------------------------------------------------------------");

        do {
            System.out.println("Go /start de bat dau");
        } while (!scanner.nextLine().equals("/start"));

        System.out.print("\n");
        System.out.println("Danh sach cac cau lenh : ");
        System.out.println("- /newDB: Khoi tao database moi");
        System.out.println("- /DBList: Tra cuu danh sach database");
        System.out.println("- /quit: Thoat chuong trinh");
        System.out.println("- /connect: Ket noi toi database");
        System.out.println("- /disconnect : Ngat ket noi toi database");
        System.out.println("- /insert : Chen bang moi vao database");
        System.out.println("- /showall : Chieu toan bo bang trong database");
        System.out.println("- /search : Tim kiem trong bang");
        System.out.println("- /delete : Xoa thanh phan trong bang");
        System.out.println("- /update : Cap nhat thanh phan trong bang");
        System.out.println("- /reward : Xem danh sach nhan vien duoc khen thuong");
        System.out.print("\n");

        while (currState) {
            switch (scanner.nextLine()) {
                case "/quit" -> {
                    currState = false;
                    System.out.println("Thoat chuong trinh...");
                }

                case "/newDB" -> {
                    System.out.println("Nhap ten database : ");
                    newDB(scanner.nextLine());
                    System.out.print("\n");
                }

                case "/DBList" -> {
                    DBList = DBScanner.list();

                    assert DBList != null : "Khong co database nao trong danh sach";
                    System.out.println("Danh sach database : ");

                    for (String DBListUnit : DBList ){
                        System.out.println(DBListUnit);
                    }

                    System.out.print("\n");
                }

                case "/help" -> {
                    System.out.println("Danh sach cac cau lenh: ");
                    System.out.println("- /newDB: Khoi tao database moi");
                    System.out.println("- /DBList: Tra cuu danh sach database");
                    System.out.println("- /quit: Thoat chuong trinh");
                    System.out.println("- /connect: Ket noi toi database");
                    System.out.println("- /disconnect : Ngat ket noi toi database");
                    System.out.println("- /insert : Chen bang moi vao database");
                    System.out.println("- /showall : Chieu toan bo bang trong database");
                    System.out.println("- /showsort : Chieu bang trong database theo loai");
                    System.out.println("- /search : Tim kiem trong bang");
                    System.out.println("- /delete : Xoa thanh phan trong bang");
                    System.out.println("- /update : Cap nhat thanh phan trong bang");
                    System.out.println("- /reward : Xem danh sach nhan vien duoc khen thuong");
                    System.out.print("\n");
                }

                case "/connect" -> {
                    dbname = false;
                    String dbinput;
                    DBList = DBScanner.list();
                    System.out.println("Nhap ten database muon truy cap toi: ");
                    dbinput = scanner.nextLine();
                    for (String DBListUnit : DBList) {
                        if (DBListUnit.equals(dbinput + ".db")) {
                            dbname = true;
                            break;
                        }
                    }
                    if (dbname){
                        connect(dbinput);
                    } else {
                        System.out.println("Khong ton tai database, thu nhap lai voi cau lenh /connect");
                        System.out.print("\n");
                    }
                }

                case "/update" -> {
                    int value;
                    System.out.println("Nhap ma so nhan vien: ");
                    value = Integer.parseInt(scanner.nextLine());
                    String kieuCanBo;
                    String tenCanBo;
                    int soLuong;
                    int dieuHuong;
                    System.out.println("Chon kieu can bo: ");
                    System.out.println("- Go #giangday de nhap kieu can bo giang day");
                    System.out.println("- Go #nghiencuu de nhap kieu can bo nghien cuu");
                    System.out.println("- Go #phucvu de nhap kieu can bo phuc vu");

                    kieuCanBo = scanner.nextLine();
                    switch (kieuCanBo) {
                        case "#giangday" -> {
                            kieuCanBo = "Giang day";
                            dieuHuong = 1;
                        }
                        case "#nghiencuu" -> {
                            kieuCanBo = "Nghien cuu";
                            dieuHuong = 2;
                        }
                        case "#phucvu" -> {
                            kieuCanBo = "Phuc vu";
                            dieuHuong = 3;
                        }
                        default -> {
                            System.out.println("Kieu khong hop le");
                            return;
                        }
                    }

                    System.out.println("Nhap ten can bo: ");
                    tenCanBo = scanner.nextLine();
                    System.out.println("Nhap so luong: ");
                    soLuong = Integer.parseInt(scanner.nextLine());

                    updateElement(value ,dieuHuong, kieuCanBo, tenCanBo, soLuong);
                }

                case "/disconnect" -> disconnect();


                case "/insert" -> {
                    String kieuCanBo;
                    String tenCanBo;
                    int soLuong;
                    int dieuHuong;
                    System.out.println("Chon kieu can bo: ");
                    System.out.println("- Go #giangday de nhap kieu can bo giang day");
                    System.out.println("- Go #nghiencuu de nhap kieu can bo nghien cuu");
                    System.out.println("- Go #phucvu de nhap kieu can bo phuc vu");

                    kieuCanBo = scanner.nextLine();
                    switch (kieuCanBo) {
                        case "#giangday" -> {
                            kieuCanBo = "Giang day";
                            dieuHuong = 1;
                        }
                        case "#nghiencuu" -> {
                            kieuCanBo = "Nghien cuu";
                            dieuHuong = 2;
                        }
                        case "#phucvu" -> {
                            kieuCanBo = "Phuc vu";
                            dieuHuong = 3;
                        }
                        default -> {
                            System.out.println("Kieu khong hop le");
                            return;
                        }
                    }

                    System.out.println("Nhap ten can bo: ");
                    tenCanBo = scanner.nextLine();
                    System.out.println("Nhap so luong: ");
                    soLuong = Integer.parseInt(scanner.nextLine());

                    insertElement(dieuHuong, kieuCanBo, tenCanBo, soLuong);
                }

                case "/delete" -> {
                    int value;
                    System.out.println("Nhap ma so nhan vien: ");
                    value = Integer.parseInt(scanner.nextLine());
                    deleteElement(value);
                }

                case "/showall" -> timKiemParent.displayTable();

                case "/showsort" -> timKiem.displayMiniTable();

                case "/reward" -> {
                    String inputCheck;
                    int value;
                    System.out.println("Chon kieu can bo: ");
                    System.out.println("- Go #giangday de nhap kieu can bo giang day");
                    System.out.println("- Go #nghiencuu de nhap kieu can bo nghien cuu");
                    System.out.println("- Go #phucvu de nhap kieu can bo phuc vu");
                    System.out.println("- Go #all de hien thi tat ca");

                    inputCheck = scanner.nextLine();
                    switch (inputCheck) {
                        case "#giangday" -> {
                            System.out.println("Nhap so gio giang day chuan: ");
                            value = Integer.parseInt(scanner.nextLine()) * 5/4;
                            timKiem.filteredSearch("So_gio_giang_day", value);
                        }

                        case "#nghiencuu" -> {
                            System.out.println("Nhap so bai bao chuan: ");
                            value = Integer.parseInt(scanner.nextLine()) + 2;
                            timKiem.filteredSearch("So_bai_bao", value);
                        }

                        case "#phucvu" -> {
                            System.out.println("Nhap so gio phuc vu chuan: ");
                            value = Integer.parseInt(scanner.nextLine()) * 3/2;
                            timKiem.filteredSearch("So_gio_phuc_vu", value);
                        }

                        case "#all" -> {
                            System.out.println("Nhap so gio giang day chuan: ");
                            value = Integer.parseInt(scanner.nextLine());
                            timKiem.filteredSearch("So_gio_giang_day", value);

                            System.out.println("Nhap so bai bao chuan: ");
                            value = Integer.parseInt(scanner.nextLine());
                            timKiem.filteredSearch("So_bai_bao", value);

                            System.out.println("Nhap so gio phuc vu chuan: ");
                            value = Integer.parseInt(scanner.nextLine());
                            timKiem.filteredSearch("So_gio_phuc_vu", value);
                        }
                    }
                }

                case"/search" -> {
                    String inputCheck;
                    int searchType;
                    int modifierType;
                    int value;
                    System.out.println("Chon kieu can bo: ");
                    System.out.println("- Go #giangday de nhap kieu can bo giang day");
                    System.out.println("- Go #nghiencuu de nhap kieu can bo nghien cuu");
                    System.out.println("- Go #phucvu de nhap kieu can bo phuc vu");
                    System.out.println("- Go #maso de tim theo ma so");

                    inputCheck = scanner.nextLine();
                    switch (inputCheck) {
                        case "#giangday" -> searchType = 1;
                        case "#nghiencuu" -> searchType = 2;
                        case "#phucvu" -> searchType = 3;
                        case "#maso" -> {
                            searchType = 4;
                            modifierType = 3;
                            System.out.println("Nhap ma so nhan vien: ");
                            value = Integer.parseInt(scanner.nextLine());
                            timKiemParent.filteredSearch(searchType, modifierType, value);
                        }
                        default -> {
                            System.out.println("Kieu khong hop le");
                            return;
                        }
                    }

                    System.out.println("Chon kieu tim kiem: ");
                    System.out.println("- Go > de tim lon hon");
                    System.out.println("- Go < de tim nho hon");
                    System.out.println("- Go = de tim ngang bang");
                    inputCheck = scanner.nextLine();
                    switch (inputCheck) {
                        case ">" -> modifierType = 1;
                        case "<" -> modifierType = 2;
                        case "=" -> modifierType = 3;
                        default -> {
                            System.out.println("Kieu khong hop le");
                            return;
                        }
                    }

                    System.out.println("Nhap gia tri: ");
                    value = Integer.parseInt(scanner.nextLine());

                    timKiemParent.filteredSearch(searchType, modifierType, value);
                }

                default -> {
                    System.out.println("Cau lenh khong hop le go /help de tra cuu danh sach cac lenh");
                    System.out.print("\n");
                }
            }
        }
    }
}
