package com.upc.deploy20251.service;

import com.upc.deploy20251.dto.CiudadDTO;
import com.upc.deploy20251.model.Ciudad;
import com.upc.deploy20251.repository.CiudadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CiudadService {
    final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }
    public List<CiudadDTO> listar() {
        List<CiudadDTO> ciudadDTOS = new ArrayList<>();
        List<Ciudad> ciudades = ciudadRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        CiudadDTO ciudadDTO;
        for (Ciudad ciudad : ciudades) {
            ciudadDTO = modelMapper.map(ciudad, CiudadDTO.class);
            ciudadDTOS.add(ciudadDTO);

        }
        return ciudadDTOS;
      }
      public CiudadDTO buscarPorId(Long id) {
        Ciudad ciudad = ciudadRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();
        CiudadDTO ciudadDTO = modelMapper.map(ciudad, CiudadDTO.class);
        return ciudadDTO;
      }
      public Ciudad guardar(CiudadDTO ciudadDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Ciudad ciudad = modelMapper.map(ciudadDTO, Ciudad.class);
        return ciudadRepository.save(ciudad);
      }
      public String eliminar(Long id) {
            ciudadRepository.deleteById(id);
            return "Ciudad eliminada";
        }
}
