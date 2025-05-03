package com.example.api_sem4.service;

import com.example.api_sem4.dto.PaymentRequestDTO;
import com.example.api_sem4.dto.PaymentResponseDTO;
import com.example.api_sem4.entity.Payment;
import com.example.api_sem4.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentResponseDTO createPayment(PaymentRequestDTO dto) {
        Payment payment = new Payment();
        payment.setMonth(dto.getMonth());
        payment.setTuitionFee(dto.getTuitionFee());
        payment.setLunchFee(dto.getLunchFee());
        payment.setAdditionalFee(dto.getAdditionalFee());
        payment.setDeadlineDay(dto.getDeadlineDay());
        payment.setTotalFee(dto.getTuitionFee() + dto.getLunchFee() + dto.getAdditionalFee());

        Payment saved = paymentRepository.save(payment);
        return mapToResponseDTO(saved);
    }

    public PaymentResponseDTO updatePayment(Long id, PaymentRequestDTO dto) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setMonth(dto.getMonth());
        payment.setTuitionFee(dto.getTuitionFee());
        payment.setLunchFee(dto.getLunchFee());
        payment.setAdditionalFee(dto.getAdditionalFee());
        payment.setDeadlineDay(dto.getDeadlineDay());
        payment.setTotalFee(dto.getTuitionFee() + dto.getLunchFee() + dto.getAdditionalFee());

        Payment updated = paymentRepository.save(payment);
        return mapToResponseDTO(updated);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
    private PaymentResponseDTO mapToResponseDTO(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(payment.getId());
        dto.setMonth(payment.getMonth());
        dto.setTuitionFee(payment.getTuitionFee());
        dto.setLunchFee(payment.getLunchFee());
        dto.setAdditionalFee(payment.getAdditionalFee());
        dto.setTotalFee(payment.getTotalFee());
        dto.setDeadlineDay(payment.getDeadlineDay());
        return dto;
    }
}
