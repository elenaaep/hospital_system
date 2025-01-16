package com.hospital.hospital_system.service;

import com.hospital.hospital_system.dto.MesajDTO;
import com.hospital.hospital_system.models.Mesaj;

import java.util.List;

public interface MessageService {
    Mesaj sendMessage(MesajDTO mesajDTO);
    List<Mesaj> getAllMessages();
    Mesaj getMessageById(Long id);
}
