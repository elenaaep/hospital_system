package com.hospital.hospital_system.service.impl;

import com.hospital.hospital_system.dto.DoctorDto;
import com.hospital.hospital_system.models.Doctor;
import com.hospital.hospital_system.repository.DoctorRepository;
import com.hospital.hospital_system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DoctorDto> findAllDoctor() {
        List<Doctor> doctor = doctorRepository.findAll();
        return doctor.stream()
                .map(doctor1 -> mapToDoctorDto(doctor1))
                .collect(Collectors.toList());
    }

    private DoctorDto mapToDoctorDto(Doctor doctor1){
        DoctorDto doctorDto=DoctorDto.builder()
                .idDoc(doctor1.getIdDoc())
                .titlu(doctor1.getTitlu())
                .nume(doctor1.getNume())
                .prenume(doctor1.getPrenume())
                .cnp(doctor1.getCnp())
                .dataNasterii(doctor1.getDataNasterii())
                .gen(doctor1.getGen())
                .tel(doctor1.getTel())
                .email(doctor1.getEmail())
                .departament(doctor1.getDepartament())
                .specializare(doctor1.getSpecializare())
                .etaj(doctor1.getEtaj())
                .competente(doctor1.getCompetente())
                .build();
        return doctorDto;

    }
}
