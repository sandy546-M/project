document.addEventListener('DOMContentLoaded', function() {
    const createGroupBtn = document.getElementById('create-group-btn');
    const groupPopup = document.getElementById('group-popup');
    const closePopup = document.getElementById('close-popup');
    const createGroupConfirm = document.getElementById('create-group-confirm');
    const groupList = document.getElementById('group-list');
    const groupNameInput = document.getElementById('group-name');
    const groupColorInput = document.getElementById('group-color');
    const notesList = document.getElementById('notes-list');
    const noteText = document.getElementById('note-text');
    const sendNoteBtn = document.getElementById('send-note-btn');
    const groupTitle = document.getElementById('group-title');
    
    let groups = JSON.parse(localStorage.getItem('groups')) || [];
    let selectedGroupId = null;
    
    function renderGroups() {
        groupList.innerHTML = '';
        groups.forEach(group => {
            const li = document.createElement('li');
            li.textContent = group.name;
            li.style.backgroundColor = group.color;
            li.addEventListener('click', () => selectGroup(group.id));
            groupList.appendChild(li);
        });
    }
    
    function renderNotes() {
        notesList.innerHTML = '';
        if (selectedGroupId !== null) {
            const group = groups.find(group => group.id === selectedGroupId);
            group.notes.forEach(note => {
                const div = document.createElement('div');
                div.textContent = `${note.text} (${note.date})`;
                notesList.appendChild(div);
            });
        }
    }
    
    function selectGroup(groupId) {
        selectedGroupId = groupId;
        const group = groups.find(group => group.id === selectedGroupId);
        groupTitle.textContent = group.name;
        renderNotes();
    }
    
    createGroupBtn.addEventListener('click', () => {
        groupPopup.style.display = 'flex';
    });
    
    closePopup.addEventListener('click', () => {
        groupPopup.style.display = 'none';
    });
    
    createGroupConfirm.addEventListener('click', () => {
        const name = groupNameInput.value.trim();
        const color = groupColorInput.value;
        
        if (name) {
            const groupId = Date.now();
            groups.push({ id: groupId, name, color, notes: [] });
            localStorage.setItem('groups', JSON.stringify(groups));
            renderGroups();
            groupPopup.style.display = 'none';
            groupNameInput.value = '';
        }
    });
    
    sendNoteBtn.addEventListener('click', () => {
        const text = noteText.value.trim();
        if (text && selectedGroupId !== null) {
            const group = groups.find(group => group.id === selectedGroupId);
            const date = new Date().toLocaleString();
            group.notes.push({ text, date });
            localStorage.setItem('groups', JSON.stringify(groups));
            noteText.value = '';
            sendNoteBtn.disabled = true;
            renderNotes();
        }
    });
    
    noteText.addEventListener('input', () => {
        sendNoteBtn.disabled = noteText.value.trim() === '';
    });
    
    window.addEventListener('click', (e) => {
        if (e.target === groupPopup) {
            groupPopup.style.display = 'none';
        }
    });
    
    renderGroups();
});