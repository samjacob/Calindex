package com.calindex.db;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.calindex.domain.OptOut;

/**
 * This is the DAO class for the OPT_OUT table.
 *
 * @author 410908
 * @since Oct 7, 2014
 */
@Repository("OptOutDao")
@Transactional(propagation = Propagation.REQUIRED)
public class OptOutDao {

    /** The entity manager. */
    @PersistenceContext
    private EntityManager entityManager;

    /** The Constant log. */
    private static final Logger log = Logger.getLogger(OptOutDao.class);

    /**
     * Query the OptOut table to get all the Records <br>
     * <i>>> SELECT * FROM OPT_OUT </i>.
     *
     * @return all records from the OPT_OUT table
     */
    @SuppressWarnings("unchecked")
    public List<OptOut> getAllOptOutRecords() {
        Criteria hibernateCriteria = getBaseCriteria();
        List<OptOut> allRecords = (List<OptOut>) hibernateCriteria.list();
        log.trace("Fetched [" + allRecords.size() + "] from the Database!");
        return allRecords;
    }

    /**
     * Query the OptOut table to get records for which optout has not been processed <br>
     * <i>>> SELECT * FROM OPT_OUT WHERE PROCESSED IN ('N' or '') </i>.
     *
     * @return matching records
     */
    @SuppressWarnings("unchecked")
    public List<OptOut> getUnprocessedRecords() {
        Criteria hibernateCriteria = getBaseCriteria();
        hibernateCriteria.add(Restrictions.in(OptOut.RECORD_PROCESSED, Arrays.asList("N", "", null)));
        List<OptOut> allRecords = (List<OptOut>) hibernateCriteria.list();
        log.trace("Fetched [" + allRecords.size() + "] unprocessed records from the Database!");
        return allRecords;
    }

    /**
     * Persist the records to the databases.
     *
     * @param optOut
     *            the opt out form
     */
    public void persistRecord(OptOut optOut) {
        // Setting the transaction ID to persist in the database
        optOut.setTransactionId(UUID.randomUUID().toString());
        // Setting the IS_PROCESSED status as NO('N').
        optOut.setProcessedStatus("N");
        entityManager.persist(optOut);
        if (log.isDebugEnabled()) log.debug("Record is been persisted in the Database!");
    }

    /**
     * Update the IS_PROCESSED status for the given records with '<b>Y</b>'.
     *
     * @param recordsForUpdate
     *            the records for update
     */
    public void updateProcessedStatus(List<OptOut> recordsForUpdate) {
        log.trace("Updating [" + recordsForUpdate.size() + "] records by changing the IS_PROCESSED status to Y...");
        for (OptOut record : recordsForUpdate) {
            record.setProcessedStatus("Y");
            entityManager.merge(record);
        }
        log.trace("Update completed!");
    }

    /**
     * This method creates an base Criteria object for OptOut without any restrictions.
     * It returns an output similar to running a direct 'SELECT * FROM OPT_OUT' type of query.
     * 
     * @return - an base Criteria object for OptOut without any restrictions
     */
    private Criteria getBaseCriteria() {
        Session session = (Session) entityManager.getDelegate();// Get a hibernate session for building Criteria
        Criteria hibernateCriteria = session.createCriteria(OptOut.class);// Get a hibernate criteria for adding Restrictions
        return hibernateCriteria;
    }

    /**
     * Gets the entity manager.
     *
     * @return the entity manager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Sets the entity manager.
     *
     * @param entityManager
     *            the new entity manager
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
