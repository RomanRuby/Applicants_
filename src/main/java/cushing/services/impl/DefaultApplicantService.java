package cushing.services.impl;

import cushing.models.dictionary.Office;
import cushing.models.entity.Applicant;
import cushing.models.entity.Vacancy;
import cushing.repository.ApplicantRepository;
import cushing.services.ApplicantService;
import cushing.services.OfficeService;
import cushing.services.VacancyService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Roman Nagibov
 */
@Service
@Transactional(readOnly = true)
public class DefaultApplicantService implements ApplicantService {

    @Autowired private VacancyService vacancyService;
    @Autowired private ApplicantRepository applicantRepository;
    @Autowired private OfficeService officeService;


    @Nullable
    @Override
    public Applicant get(@NotNull Long id) {
        return applicantRepository.findOne(id);
    }

    @Transactional
    @NotNull
    @Override
    public Applicant save(@NotNull Applicant applicant) {
        Vacancy vacancy = vacancyService.get(applicant.getVacancy().getId());
        applicant.setVacancy(vacancy);

        Office office = officeService.get(applicant.getOffice().getId());
        applicant.setOffice(office);
        applicant.setIsEnabled(true);

        return applicantRepository.save(applicant);
    }

    @Transactional
    @Nullable
    @Override
    public Applicant update(@NotNull Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Transactional
    @Override
    public void delete(@NotNull Long id) {
        Applicant applicant = applicantRepository.findOne(id);
        applicant.setIsEnabled(false);

        applicantRepository.save (applicant);
    }

    @NotNull
    @Override
    public List<Applicant> getAll() {
        return applicantRepository.findAllByIsEnabledTrue();
    }

}
