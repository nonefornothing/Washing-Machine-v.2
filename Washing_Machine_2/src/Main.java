import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<String> pakaiankotor = new ArrayList<String>();
	public static ArrayList<String> pakaianCuci = new ArrayList<String>();
	public static ArrayList<String> pakaianBersih = new ArrayList<String>();
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int pilihan;
		int banyakPakaian;
		String jenisBaju;
		int pilihanMenu;

		while (true) {
			System.out.println();
			menuAwal();

			pilihanMenu = getInteger();

			if (pilihanMenu == 1) {
				System.out.println("Pilih cara memasukkan pakaian kotor ");
				System.out.println("1. Satu-satu ");
				System.out.println("2. Banyak ");
				pilihan = getInteger();
				if (pilihan == 1) {
					System.out.println("Masukkan Jenis Pakaian : ");
					input.nextLine();
					jenisBaju = input.nextLine();
					pakaiankotor.add(jenisBaju);
					System.out.println(pakaiankotor);
				} else if (pilihan == 2) {
					System.out.println("Mau berapa banyak pakaian yang diinput ?");
					banyakPakaian = getInteger();
					input.nextLine();
					System.out.println("Masukkkan jenis pakaian sebanyak " + banyakPakaian);
					for (int z = 0; z < banyakPakaian; z++) {
						System.out.print("Jenis Pakaian yang ke-" + (z + 1) + " : ");
						jenisBaju = input.nextLine();
						pakaiankotor.add(jenisBaju);
					}

				}
			} else if (pilihanMenu == 2) {
				if (pakaiankotor.isEmpty()) {
					System.out.println("Pakaian yang kotor kosong");
				} else {

					System.out.println("Pakaian kotor berjumlah " + pakaiankotor.size() + " yaitu :");
					System.out.println(pakaiankotor);
					System.out.println("Input berapa pakaian yang mau di cuci?");
					banyakPakaian = getInteger();
					input.nextLine();
					if (banyakPakaian > pakaiankotor.size()) {
						System.out.println("Maaf Jumlah Pakaian yg mau di cuci lebih banyak dari pakaian Kotor");
					} else {

						for (int i = 0; i < banyakPakaian; i++) {
							System.out.println("Silahkan masukkan jenis pakaian Anda");
							jenisBaju = input.nextLine();
							for (int j = 0; j < pakaiankotor.size(); j++) {
								int count = 0;
								if (pakaiankotor.get(j).equalsIgnoreCase(jenisBaju)) {
									pakaianCuci.add(jenisBaju);
									pakaiankotor.remove(pakaiankotor.get(j));
									count++;
								} else if (j == pakaiankotor.size() && count == 0) {
									System.out.println("Tidak Ada Pakaian");
								}
							}
						}

						System.out.println("Selamat Anda telah mencuci " + pakaianCuci.size() + " pakaian anda");

					}

				}

			} else if (pilihanMenu == 3) {

				if (pakaianCuci.isEmpty()) {
					System.out.println("Pakaian yang sudah dicuci kosong");
				} else {

					System.out.println("Total Pakaian sudah di cuci :" + pakaianCuci.size());
					System.out.println("Mau Ambil Berapa Pakaian ? ");
					banyakPakaian = getInteger();
					input.nextLine();

					if (banyakPakaian > pakaianCuci.size()) {
						System.out.println("Maaf Jumlah Pakaian yg mau di ambil lebih banyak dari yang sudah dicuci ");
					} else {

//							System.out.println("Silahkan Ambil Pakaian Anda");
//							for (int i = 0; i < banyakPakaian; i++) {
//								jenisBaju = input.nextLine();
//								pakaianBersih.add(jenisBaju);
//								pakaianCuci.remove(i);
//							}

						for (int i = 0; i < banyakPakaian; i++) {
							int count = 0;
							System.out.println("Silahkan masukkan jenis pakaian Anda");
							jenisBaju = input.nextLine();
							for (int j = 0; j < pakaianCuci.size(); j++) {
								if (pakaianCuci.get(j).equalsIgnoreCase(jenisBaju)) {
									pakaianBersih.add(jenisBaju);
									pakaianCuci.remove(pakaianCuci.get(j));
									count++;
								} else if (j == pakaianCuci.size() && count != 0) {
									System.out.println("Tidak Ada Pakaian");
								}
							}
						}

						System.out.println("Selamat Anda telah mengambil " + pakaianBersih.size() + " pakaian anda");
					}

				}

			} else if (pilihanMenu == 4) {
				System.out.println("Pakaian Bersih");
				for (int i = 0; i < pakaianCuci.size(); i++) {
					System.out.println(pakaianCuci.get(i) + "       ");
				}

				System.out.println();
				System.out.println("pakaian kotor");
				for (int i = 0; i < pakaiankotor.size(); i++) {
					System.out.println(pakaiankotor.get(i) + "       ");
				}

				System.out.println();
				System.out.println("pakaian diambil");
				for (int i = 0; i < pakaianBersih.size(); i++) {
					System.out.println(pakaianBersih.get(i) + "       ");
				}
				System.out.println();
			} else if (pilihanMenu == 5) {
				System.exit(0);
			}
		}
	}

	public static void menuAwal() {
		System.out.println("Pilih menu yang akan anda lakukan: ");
		System.out.println("1. Input pakaian kotor ");
		System.out.println("2. Cuci pakaian kotor ");
		System.out.println("3. Ambil pakaian bersih ");
		System.out.println("4. Laporan pakaian jumlah pakaian yang kotor , yang bersih dan yang sudah diambil ");
		System.out.println("5. Keluar aplikasi");
	}

	public static int getInteger() {
		while (true) {
			try {
				return input.nextInt();
			} catch (Exception e) {
				input.next();
				System.err.println("Ketik bilangan integer !!!!");
			}
		}
	}

}