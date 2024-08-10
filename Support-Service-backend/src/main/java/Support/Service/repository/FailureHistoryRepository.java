//package Support.Service.repository;
//
//
//import Support.Service.model.FailureHistory;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//
//@Repository
//public interface FailureHistoryRepository extends JpaRepository<FailureHistory,Long> {
//    @Query("SELECT fh FROM FailureHistory fh WHERE fh.failure.failureId = :failureId")
//    List<FailureHistory> findByFailureId(Long failureId);
//}
