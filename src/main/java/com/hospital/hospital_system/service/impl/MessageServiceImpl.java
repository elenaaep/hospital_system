package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.MesajDTO;
import com.hospital.hospital_system.models.Mesaj;
import com.hospital.hospital_system.models.Doctor;
import com.hospital.hospital_system.models.Pacienti;
import com.hospital.hospital_system.repository.MesajRepository;
import com.hospital.hospital_system.repository.DoctorRepository;
import com.hospital.hospital_system.repository.PacientiRepository;
import com.hospital.hospital_system.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MesajRepository mesajRepository;

    @Autowired
    private PacientiRepository pacientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Mesaj sendMessage(MesajDTO mesajDTO) {
        Pacienti pacient = pacientRepository.findById(mesajDTO.getPacientId()).orElseThrow(() -> new RuntimeException("Pacient nu a fost găsit"));
        Doctor doctor = doctorRepository.findById(mesajDTO.getDoctorId()).orElseThrow(() -> new RuntimeException("Doctor nu a fost găsit"));

        Mesaj mesaj = new Mesaj(pacient, doctor, mesajDTO.getMesaj(), mesajDTO.getDataMesaj());
        return mesajRepository.save(mesaj);
    }

    @Override
    public List<Mesaj> getAllMessages() {
        return mesajRepository.findAll();
    }

    @Override
    public Mesaj getMessageById(Long id) {
        return mesajRepository.findById(id).orElseThrow(() -> new RuntimeException("Mesajul nu a fost găsit"));
    }
}
