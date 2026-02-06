package task.code.controller.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.code.dto.court.CourtCreateDTO;
import task.code.dto.court.CourtDTO;
import task.code.dto.court.CourtUpdateDTO;
import task.code.exception.ResourceNotFoundException;
import task.code.mapper.CourtMapper;
import task.code.repository.CourtRepository;

import java.util.List;

@RestController
@RequestMapping("/api/courts")
@AllArgsConstructor
public class CourtController {
    private final CourtRepository courtRepository;
    private final CourtMapper courtMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourtDTO> index() {
        var courts = courtRepository.findAll();
        return courts.stream().map(courtMapper::map).toList();
    }

    @GetMapping("/{id}")
    public CourtDTO show(@PathVariable Long id) {
        var court = courtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        return courtMapper.map(court);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourtDTO create(@RequestBody @Valid CourtCreateDTO data) {
        var court = courtMapper.map(data);
        courtRepository.save(court);
        return courtMapper.map(court);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourtDTO update(@PathVariable Long id, @RequestBody CourtUpdateDTO data) {
        var court = courtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        courtMapper.update(data, court);
        courtRepository.save(court);
        return courtMapper.map(court);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        courtRepository.deleteById(id);
    }
}
