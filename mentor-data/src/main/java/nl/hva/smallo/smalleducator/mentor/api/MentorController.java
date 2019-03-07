package nl.hva.smallo.smalleducator.mentor.api;

import nl.hva.smallo.smalleducator.mentor.entity.Mentor;
import nl.hva.smallo.smalleducator.mentor.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("mentors")
public class MentorController {

    @Autowired
    private MentorRepository mentorRepository;

    @GetMapping
    public Iterable<Mentor> getMentors() {
        return mentorRepository.findAll();
    }

    @GetMapping(path = {"/by-id/{id}"})
    public Mentor getMentor(@PathVariable String id) {
        return mentorRepository.findById(UUID.fromString(id)).orElse(null);
    }

}
