package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskController controller;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void naoDeveSalvarTaskSemDescricao() {
        try {
            Task novaTask = new Task();
           // novaTask.setTask("Descrição nao pode ser null");
            novaTask.setDueDate(LocalDate.now());
            controller.save(novaTask);
            Assert.fail("Não deveria chegar aqui!!");
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void naoDeveSalvarTaskSemData(){
       try {
        Task novaTask = new Task();
        novaTask.setTask("Descrição nao pode ser null");
        controller.save(novaTask);
        Assert.fail("Não deveria chegar aqui!!");
    } catch (ValidationException e) {
        Assert.assertEquals("Fill the due date", e.getMessage());
    }
}

@Test
public void naoDeveSalvarTaskComDataPassada(){
    try {
        Task novaTask = new Task();
        novaTask.setDueDate(LocalDate.of(2013, 01,01));
        novaTask.setTask("Descricao nao pode ser null");
        controller.save(novaTask);
        Assert.fail("Não deveria chegar aqui!!");
    } catch (ValidationException e) {
        Assert.assertEquals("Due date must not be in past", e.getMessage());
    }
}

    @Test   
    public void deveSalvarTaskComSucesso() throws ValidationException {

            Task novaTask = new Task();
            novaTask.setDueDate(LocalDate.now());
            novaTask.setTask("Task with success create");
            controller.save(novaTask);

        }

    }

