package task.code.controller.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import task.code.dto.trainer.TrainerCreateDTO;
import task.code.dto.trainer.TrainerDTO;
import task.code.dto.trainer.TrainerUpdateDTO;
import task.code.exception.ResourceNotFoundException;
import task.code.mapper.TrainerMapper;
import task.code.repository.TrainerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
@AllArgsConstructor
public class TrainerController {
    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TrainerDTO> index() {
        var trainers = trainerRepository.findAll();
        return trainers.stream().map(trainerMapper::map).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainerDTO show(@PathVariable Long id) {
        var trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        return trainerMapper.map(trainer);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerDTO create(@RequestBody @Valid TrainerCreateDTO data) {
        var trainer = trainerMapper.map(data);
        trainerRepository.save(trainer);
        return trainerMapper.map(trainer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainerDTO update(@PathVariable Long id, @RequestBody TrainerUpdateDTO data) {
        var trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        trainerMapper.update(data, trainer);
        trainerRepository.save(trainer);
        return trainerMapper.map(trainer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        trainerRepository.deleteById(id);
    }
}
