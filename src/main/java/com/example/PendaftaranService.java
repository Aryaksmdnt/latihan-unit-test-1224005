package com.example;

public class PendaftaranService {

    public String validasiPendaftaran(
            String nama,
            int umur,
            String email,
            boolean setujuSyarat
    ) {

        // P1: Memeriksa apakah nama kosong atau null
        if (nama == null || nama.isEmpty()) {
            return "Nama harus diisi";
        }

        // P2: Memeriksa apakah umur minimal 17 tahun
        if (umur < 17) {
            return "Umur minimal 17 tahun";
        }

        // P3 dan P4: Memeriksa apakah email null atau tidak mengandung @
        if (email == null || !email.contains("@")) {
            return "Email tidak valid";
        }

        // P5: Memeriksa persetujuan syarat dan ketentuan
        if (!setujuSyarat) {
            return "Harus menyetujui syarat dan ketentuan";
        }

        // Jika semua validasi terpenuhi
        return "Pendaftaran berhasil";
    }
}
