package task.code.controller.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.code.dto.client.ClientCreateDTO;
import task.code.dto.client.ClientDTO;
import task.code.dto.client.ClientUpdateDTO;
import task.code.exception.ResourceNotFoundException;
import task.code.mapper.ClientMapper;
import task.code.repository.ClientRepository;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDTO> index() {
        var clients = clientRepository.findAll();
        return clients.stream().map(clientMapper::map).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO show(@PathVariable Long id) {
        var client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        return clientMapper.map(client);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO create(@RequestBody @Valid ClientCreateDTO data) {
        var client = clientMapper.map(data);
        clientRepository.save(client);
        return clientMapper.map(client);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO update(@PathVariable Long id, @RequestBody @Valid ClientUpdateDTO data) {
        var client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        clientMapper.update(data, client);
        clientRepository.save(client);
        return clientMapper.map(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
