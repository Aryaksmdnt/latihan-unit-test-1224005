package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
public class PendaftaranServiceTest {
 
    private PendaftaranService service;
 
    @BeforeEach
    void setUp() {
        service = new PendaftaranService();
    }
 
    @Test
    @DisplayName("TC-01 (Path 1): Nama kosong")
    void testNamaKosong() {
        String hasil = service.validasiPendaftaran(
                "", 20, "budi@mail.com", true);
        assertEquals("Nama harus diisi", hasil);
    }
 
    @Test
    @DisplayName("TC-02 (Path 2): Umur kurang dari 17")
    void testUmurKurang() {
        String hasil = service.validasiPendaftaran(
                "Budi", 16, "budi@mail.com", true);
        assertEquals("Umur minimal 17 tahun", hasil);
    }
 
    @Test
    @DisplayName("TC-03 (Path 3): Email null")
    void testEmailNull() {
        String hasil = service.validasiPendaftaran(
                "Budi", 20, null, true);
        assertEquals("Email tidak valid", hasil);
    }
 
    @Test
    @DisplayName("TC-04 (Path 4): Email tanpa karakter @")
    void testEmailTanpaAt() {
        String hasil = service.validasiPendaftaran(
                "Budi", 20, "budimail.com", true);
        assertEquals("Email tidak valid", hasil);
    }
 
    @Test
    @DisplayName("TC-05 (Path 5): Belum menyetujui syarat")
    void testBelumSetuju() {
        String hasil = service.validasiPendaftaran(
                "Budi", 20, "budi@mail.com", false);
        assertEquals("Harus menyetujui syarat dan ketentuan", hasil);
    }
 
    @Test
    @DisplayName("TC-06 (Path 6): Semua data valid")
    void testPendaftaranBerhasil() {
        String hasil = service.validasiPendaftaran(
                "Budi", 20, "budi@mail.com", true);
        assertEquals("Pendaftaran berhasil", hasil);
    }
}
